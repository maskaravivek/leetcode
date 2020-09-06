package interview;

public class PartitionArrayMinDifferenceSubsets {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 4, 2, 2, 1 };

        int soln = solution(arr);
        System.out.println(soln);
    }

    public static int solution(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        for (int j = sum / 2; j >= 0; j--) {
            if (dp[arr.length][j] == true) {
                diff = sum - (2 * j);
                break;
            }
        }

        return diff;
    }
}
