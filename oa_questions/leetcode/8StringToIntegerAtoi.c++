class Solution {
public:
    int myAtoi(string s) {
        int left = 0, n = s.size();
        while(left<n and s[left] == ' ')    ++left; //leading white spaces
        bool neg = false;
        if(s[left] == '-')  //Finding out the symbol 
        {
            neg = true;
            ++left;
        }
        else if(s[left] == '+')
        {
            ++left;
        }
        string str;
        while(left<n and s[left] == '0')    //leading zeros
            ++left;
        while(left<n and s[left]>='0' and  s[left]<='9')    //Finding out the number
            str.push_back(s[left++]);
        if(str.empty()) return 0;   //if empty return 0
        long int ans = string_to_integer(str,neg);
//        int ans = stoi(str);    //can use stoi too, however an extra piece of code surrounding whether the number is greater/lesser than INT_MAX or INT_MIN has to be written. The comparison is to be done on the basis of the string INT_MAX and the present string.
        return ans;
    }
    
    long int string_to_integer(string str,bool neg)
    {
        long int ans = 0;
        for(char ch:str)
        {
            long int c = ch - '0';
            ans = ans*10 + c;
            //cout<<ans<<" ";
            if(neg and -ans<=INT_MIN)
            {
                return INT_MIN;
            }
            else if(!neg and ans>=INT_MAX)
            {
                return INT_MAX;
            }
        }
        if(neg) return -ans;
        return ans;
    }
};