/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        return check(4, num);
    }

    public static boolean check(int x, int y) {
        if (y == 1) {
            return true;
        }
        double res = Math.log10(y) / Math.log10(x);

        return (res - Math.ceil(res)) == 0;
    }
}
// @lc code=end
