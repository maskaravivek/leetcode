// https://leetcode.com/discuss/interview-question/356433/
package interview;

import java.util.Arrays;

public class MinAbsDifferenceOfServerLoads {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(solution(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(solution(new int[] { 1, 2, 8, 19 }));
    }

    public static int solution(int[] arr) {
        int sum = 0;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int[][] dp = new int[arr.length][sum / 2 + 1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) {
                    if (arr[i] <= j) {
                        dp[i][j] = Math.max(0, arr[i]);
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if (arr[i] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], arr[i] + dp[i - 1][j - arr[i]]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return sum - (2 * dp[arr.length - 1][sum / 2]);
    }
}
