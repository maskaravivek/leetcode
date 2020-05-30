package leetcode;

import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {

    public static void main(final String[] args) throws java.lang.Exception {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();

        HashMap<Character, Integer> counts = new HashMap<>();
        int maxCount = 0, count = 0;
        for (int i = 0; i < len; i++) {
            counts.clear();
            count = 0;
            for (int j = i; j < len; j++) {
                char c = s.charAt(j);
                if (counts.containsKey(c)) {
                    break;
                } else {
                    count++;
                    counts.put(c, counts.getOrDefault(c, 0) + 1);
                }
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }
}