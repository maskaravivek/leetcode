package leetcode.strings;
/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class RepeatedSubstringPattern {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        char[] arr = s.toCharArray();

        String subStr = "";
        for (int i = 0; i < arr.length; i++) {
            subStr += arr[i];

            if (substrMatch(s, subStr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean substrMatch(String s, String subStr) {
        int len = subStr.length();

        if (s.length() % len != 0 || s.length() == len) {
            return false;
        }

        for (int i = 0; i < s.length(); i += len) {
            if (!s.substring(i, i + len).equals(subStr)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
