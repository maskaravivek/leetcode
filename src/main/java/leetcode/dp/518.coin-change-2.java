package leetcode.dp;
/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 *
 * https://leetcode.com/problems/coin-change-2/description/
 *
 * algorithms
 * Medium (50.37%)
 * Likes:    2210
 * Dislikes: 66
 * Total Accepted:    144.4K
 * Total Submissions: 286.4K
 * Testcase Example:  '5\n[1,2,5]'
 *
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that
 * amount. You may assume that you have infinite number of each kind of
 * coin.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: amount = 10, coins = [10] 
 * Output: 1
 * 
 * 
 * 
 * 
 * Note:
 * 
 * You can assume that
 * 
 * 
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 * 
 * 
 */

// @lc code=start
class CoinChangeII {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(change(5, new int[] { 1, 2, 5 }));
    }

    // public int change(int amount, int[] coins) {
    // int[] dp = new int[amount + 1];

    // dp[0] = 1;
    // for (int i = 0; i < coins.length; i++) {
    // for (int j = coins[i]; j <= amount; j++) {
    // dp[j] = dp[j] + dp[j - coins[i]];
    // }
    // }

    // return dp[amount];
    // }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }

        return dp[coins.length][amount];
    }
}
// @lc code=end
