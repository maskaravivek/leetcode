package leetcode.backtracking;

/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    int ways = 0;

    public int findTargetSumWays(int[] nums, int S) {
        backtracking(nums, S, 0, 0);
        return ways;
    }

    public void backtracking(int[] nums, int S, int currentSum, int idx) {
        if (idx >= nums.length) {
            if (currentSum == S) {
                ways++;
            }
            return;
        }

        backtracking(nums, S, currentSum + nums[idx], idx + 1);
        backtracking(nums, S, currentSum - nums[idx], idx + 1);
    }
}
// @lc code=end
