package interview.google;

import java.util.Arrays;

public class MaximumNumberOfStrawberries {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(solution(new int[] { 50, 10, 20, 30, 40 }, 100));
    }

    public static int solution(int[] bush, int num) {
        int[][] dp = new int[bush.length][num + 1];

        for (int i = 0; i < bush.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = solve(bush, bush.length - 1, num, dp);

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        if (res == -1) {
            return 0;
        } else {
            return res;
        }

    }

    public static int solve(int[] bush, int idx, int available, int[][] dp) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx][available] == -1) {
            int notSelected = solve(bush, idx - 1, available, dp);
            int selected = available - bush[idx] < 0 ? 0 : bush[idx] + solve(bush, idx - 2, available - bush[idx], dp);

            dp[idx][available] = Math.max(selected, notSelected);
        }

        return dp[idx][available];
    }
}
