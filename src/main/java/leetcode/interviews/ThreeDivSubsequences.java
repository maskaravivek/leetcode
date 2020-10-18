package leetcode.interviews;

public class ThreeDivSubsequences {
    int threeDivSubsequences(String number) {
        return countDivBy3(number.toCharArray());
    }

    static int MAX = 100002;

    static int div(int i, int m, char s[], int dp[][]) {
        if (i == s.length) {
            return 0;
        }

        if (dp[i][m] != -1) {
            return dp[i][m];
        }

        int x = s[i] - '0';

        int result = ((x + m) % 3 == 0) ? 1 + div(i + 1, (m + x) % 3, s, dp) : div(i + 1, (m + x) % 3, s, dp);
        dp[i][m] = result;
        return dp[i][m];
    }

    static int countDivBy3(char s[]) {
        int n = s.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }

        int result = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                result++;
            } else {
                result += div(i, 0, s, dp);
            }
        }

        return result;
    }

}