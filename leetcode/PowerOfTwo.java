// https://leetcode.com/problems/power-of-two/

package leetcode;

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==1) {
            return true;
        }
        int rem = 1;
        while(n>1) {
            rem = n%2;
            if(rem !=0) {
                return false;
            }
            n = n/2;
        } 
        return rem == 0;
    }
}