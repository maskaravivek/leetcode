// https://leetcode.com/problems/longest-palindromic-substring/

package leetcode.dp;

/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 1; i < len; i++) {
            if (arr[i - 1] == arr[i]) {
                dp[i - 1][i] = true;
            }
        }

        for (int i = 1; i < len - 1; i++) {
            if (arr[i - 1] == arr[i + 1]) {
                dp[i - 1][i + 1] = true;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (i > 0 && j < len - 1 && i - 1 <= j + 1) {
                    dp[i - 1][j + 1] = ((dp[i][j] && (arr[i - 1] == arr[j + 1]))) || dp[i - 1][j + 1];
                }
            }
        }

        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]) {
                    if (j - i + 1 > end - start) {
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }

        return s.substring(start, end);
    }
}
// @lc code=end
