// https://leetcode.com/problems/longest-palindrome/

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class LongestPalindrome {
    public int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int odds = 0, even = 0;

        for (Character key : map.keySet()) {
            int freq = map.get(key);
            if (freq % 2 == 0) {
                even += freq;
            } else {
                if (freq == 1) {
                    odds = 1;
                } else {
                    even += freq - 1;
                    odds = 1;
                }
            }
        }

        return even + odds;
    }
}
// @lc code=end
