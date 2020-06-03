// https://leetcode.com/problems/minimum-cost-for-tickets

package leetcode;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] travelDays = new boolean[366];

        for (int i = 0; i < days.length; i++) {
            travelDays[days[i]] = true;
        }

        int dp[] = new int[366];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 365; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            min = dp[i - 1] + costs[0];
            min = Math.min(min, dp[Math.max(0, i - 7)] + costs[1]);
            min = Math.min(min, dp[Math.max(0, i - 30)] + costs[2]);
            dp[i] = min;
        }
        return dp[365];
    }
}