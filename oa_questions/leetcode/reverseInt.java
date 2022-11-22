class Solution {
    public int reverse(int x) {
        int origin = x;
        int last, rev=0;
        
        while(origin!=0)
        {
            last=origin%10;
            
            if(rev>(214748364) || (rev==214748364 && (last>7)))
            {
                return 0;
            }

            if(rev<-(214748364) || (rev==-214748364 && (last==-9)))
            {
                return 0;
            }

            rev=rev*10 + last;
            origin=origin/10;
        }
        
        return rev;
    }
}

// So we only need to check the edge case where the integer overflow happens. Otherwise it is a simple number reversal question.

// The trick i am going to use is if the integer exceeds the limit i.e. 2^31 it becomes -2^31-1. See, the integer range is [-(2^31+1), 2^31]. When it exceeds the value is comes back to the lower limit. Now i will use the fact that it becomes negative when integer overflow happens. But the problem is it will keep changing the sign after every 2147483648 numbers i.e. after 4294967296 it will become 0, after 6442450944 it will become negative again and so oon.

// The integer which give integer overflow after reversal will be something like xxxxxxxxx3 or xxxxxxxxx4 ( A 10 digit number unding with 3 or more because after reversal it will definetly exceed 2147483648). Also the integer will never exceed 10 digits and less than 10 digits are no problem.

// So for numbers bigger than 4294967296 we can simply check the last digit before reversal if its greater than 4 then definetly it will exceed integer limit. For number less than that we can check it is changing sign then integer overflow is happening.


class Solution {
    public int reverse(int x) {
        int ans=0;
        int sign=1;
        
        if(x<0){
            x=-x;
            sign=-1;
        }
        
        if(Math.log10(x)+1 >=10 && x%10>3)return 0;
        
        while(x!=0){
            ans= 10*ans + x%10;
            x/=10;
            if(ans<0)return 0;
        }
        
        return ans*sign;
    }
}