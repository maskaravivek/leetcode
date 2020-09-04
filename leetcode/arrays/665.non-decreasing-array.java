// https://leetcode.com/problems/subtree-of-another-tree/

package leetcode.arrays;
/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 */

// @lc code=start
class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int violations = 0;
        for (int i = 1; i < nums.length && violations <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                violations++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return violations <= 1;
    }
}
// @lc code=end
