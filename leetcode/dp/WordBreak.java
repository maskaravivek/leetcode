// https://leetcode.com/problems/word-break/
package leetcode.dp;

import java.util.List;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean dp[] = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}