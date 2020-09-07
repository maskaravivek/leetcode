// https://leetcode.com/problems/last-stone-weight-ii
package leetcode.dp;

/*
 * @lc app=leetcode id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 */

// @lc code=start
class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sumA = 0;
        for (int a : stones) {
            sumA += a;
            for (int i = Math.min(1500, sumA); i >= a; --i)
                dp[i] |= dp[i - a];
        }
        for (int i = sumA / 2; i >= 0; --i)
            if (dp[i])
                return sumA - i - i;
        return 0;
    }
}
// @lc code=end
