// https://leetcode.com/problems/arranging-coins/

package leetcode;

class ArrangeCoins {
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        int i = 1, stairs = 1;
        while ((i += (stairs + 1)) <= n && i > 0) {
            stairs++;
        }
        return stairs;
    }
}