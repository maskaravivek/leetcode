// https://leetcode.com/problems/cherry-pickup-ii/
// https://leetcode.com/discuss/interview-question/584289/

package leetcode.dp;

/*
 * @lc app=leetcode id=1463 lang=java
 *
 * [1463] Cherry Pickup II
 */

// @lc code=start
class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];

        return dfs(grid, m, n, 0, 0, n - 1, dp);
    }

    public int dfs(int[][] grid, int m, int n, int row, int col1, int col2, Integer[][][] dp) {
        if (row == m) {
            return 0;
        }

        if (dp[row][col1][col2] != null) {
            return dp[row][col1][col2];
        }

        int ans = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newCol1 = col1 + i;
                int newCol2 = col2 + j;

                if (newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n) {
                    ans = Math.max(ans, dfs(grid, m, n, row + 1, newCol1, newCol2, dp));
                }
            }
        }

        int cherries = col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];
        dp[row][col1][col2] = ans + cherries;
        return dp[row][col1][col2];
    }
}
// @lc code=end
