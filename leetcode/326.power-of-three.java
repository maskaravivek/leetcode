// https://leetcode.com/problems/power-of-three/

package leetcode;

/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class PowerOfThree {

    // https://stackoverflow.com/questions/1804311/how-to-check-if-an-integer-is-a-power-of-3
    public boolean isPowerOfThree(int n) {
        return n> 0 && Math.pow(3, 19) % n == 0;
    }
}
// @lc code=end
