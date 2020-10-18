// https://leetcode.com/problems/reverse-string-ii

package leetcode;

public class ReverseStringII {

    public static void main(final String[] args) throws java.lang.Exception {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        int len = s.length();

        String result = "";
        int start = 0, idx = 0;

        while (start < len) {
            idx = start + k - 1;
            idx = idx >= len? len -1: idx;
            while (idx >= start && idx< len) {
                result += s.charAt(idx);
                idx--;
            }

            idx = start + k;
            int end = start + 2 * k;
            while (idx < end && idx < len) {
                result += s.charAt(idx);
                idx++;
            }

            start = end;
        }
        return result;
    }
}