// https://leetcode.com/problems/partition-equal-subset-sum/

package leetcode.dp;
/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < target + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]);
            }
        }

        return dp[nums.length][target];
    }
}
// @lc code=end
