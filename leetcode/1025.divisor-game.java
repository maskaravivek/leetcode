
// https://leetcode.com/problems/divisor-game/

package leetcode;
/*
 * @lc app=leetcode id=1025 lang=java
 *
 * [1025] Divisor Game
 */

// @lc code=start
class DivisorGame {
    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }

        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= N; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N];
    }
}
// @lc code=end
