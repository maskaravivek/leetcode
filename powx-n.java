// https://leetcode.com/problems/powx-n/

class PowXN {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            n = - (Integer.MAX_VALUE - 1);
        }
        
        if(n == 0) {
            return 1;
        } else if(x == 1) {
            return 1;
        } else if(n < 0) {
            return 1.0/myPow(x, -n);
        } else {
            if(n%2 == 1) {
                return x * myPow(x, n-1);       
            } else {
                double sqrt = myPow(x, n/2);       
                return sqrt*sqrt;
            }
            
        }
    }
}