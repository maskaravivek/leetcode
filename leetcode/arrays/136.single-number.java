// https://leetcode.com/problems/single-number/

package leetcode.arrays;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int xor = nums[0];

        for (int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        return xor;
    }
}
// @lc code=end
