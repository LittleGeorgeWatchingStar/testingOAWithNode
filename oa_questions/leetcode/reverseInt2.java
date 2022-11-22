class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while(x != 0){
        int lastDigit = x % 10;
            
            if((rev > Integer.MAX_VALUE / 10) || (rev < Integer.MIN_VALUE / 10)){ 
            return 0;
            }
            
            rev = rev * 10 + lastDigit;
            x = x / 10;
        }
        return rev; 
    }
}

class Solution {
    public int reverse(int x) {
        // signMultiplier = -1 for negative numbers
        // signMultiplier = 1 for positive numbers
        int signMultiplier = 1;
        if (x < 0) {
            signMultiplier = -1;
            x = signMultiplier * x;
        }
        int rev= 0;
        while( x != 0){
            // Check if the result is within MaxInt32 and MinInt32 bounds
             if (rev * signMultiplier > Integer.MAX_VALUE / 10 || rev * signMultiplier < Integer.MIN_VALUE / 10) {
                return 0; // or we could be direct rev * 1 || rev * -1 and compare >< 
            }
            rev= rev*10 + x % 10; //since we are always storing negative in rev so it is not changed
            x= x/10;
        }
          // Restore to original sign of number (+ or -)
        return (int)(signMultiplier * rev);
    }
}