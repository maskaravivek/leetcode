package leetcode;

// https://leetcode.com/problems/reverse-integer/

class ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;
        int sign = x >= 0? 1:0;
        int num = Math.abs(x);
        while(num / 10 > 0) {
            try {
                reversed = Math.addExact(Math.multiplyExact(reversed, 10), num%10); 
            } catch(ArithmeticException e) {
                return 0;
            }
            num = num / 10;
        } 
        if(num>0) {
            try {
                reversed = Math.addExact(Math.multiplyExact(reversed, 10), num);   
            } catch(ArithmeticException e) {
                return 0;
            }
        }
        return sign == 1? reversed: reversed*-1;
    }
}