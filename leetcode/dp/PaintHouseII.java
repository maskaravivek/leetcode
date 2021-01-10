// https://leetcode.com/problems/paint-house-ii/

package leetcode.dp;

import java.util.PriorityQueue;

class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[costs.length][costs[0].length];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
            queue.add(new int[] { i, dp[0][i] });
        }

        for (int i = 1; i < costs.length; i++) {
            int[] min = queue.poll();
            int[] secondMin = queue.poll();

            queue.clear();
            for (int j = 0; j < costs[0].length; j++) {
                int prevCost = 0;
                if (min[0] == j) {
                    prevCost = secondMin[1];
                } else {
                    prevCost = min[1];
                }
                dp[i][j] = prevCost + costs[i][j];

                queue.add(new int[] { j, dp[i][j] });
            }
        }

        int[] min = queue.poll();
        return min[1];
    }
}