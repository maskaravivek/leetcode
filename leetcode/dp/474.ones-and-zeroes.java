package leetcode.dp;

/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] zeroes = new int[strs.length];
        int[] ones = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();

            for (int j = 0; j < str.length; j++) {
                if (str[j] == '1') {
                    ones[i]++;
                } else if (str[j] == '0') {
                    zeroes[i]++;
                }
            }
        }

        return 0;
    }
}
// @lc code=end
