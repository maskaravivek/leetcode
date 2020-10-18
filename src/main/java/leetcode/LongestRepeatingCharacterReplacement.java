// https://leetcode.com/problems/longest-repeating-character-replacement

package leetcode;

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s.length() <= 1) {
            return 0;
        }

        int count[] = new int[26];
        int res = 0;
        int left = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(i) - 'A']);

            while (i - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}