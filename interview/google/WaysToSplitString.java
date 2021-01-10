// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
// https://leetcode.com/discuss/interview-question/553399/

package interview.google;

public class WaysToSplitString {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(solution("aacaba"));
        System.out.println(solution("abcd"));
        System.out.println(solution("aaaaa"));
        System.out.println(solution("acbadbaada"));
    }

    public static int solution(String s) {

        if (s.length() == 1) {
            return 0;
        }
        char[] arr = s.toCharArray();

        int[] freqLeft = new int[26];
        int[] freqRight = new int[26];

        int countLeft = 1, countRight = 0, ans = 0;

        freqLeft[arr[0] - 'a']++;

        for (int i = 1; i < arr.length; i++) {
            freqRight[arr[i] - 'a']++;
            if (freqRight[arr[i] - 'a'] == 1) {
                countRight++;
            }
        }

        if (countLeft == countRight) {
            ans++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (++freqLeft[arr[i] - 'a'] == 1) {
                countLeft++;
            }
            if (--freqRight[arr[i] - 'a'] == 0) {
                countRight--;
            }
            if (countLeft == countRight) {
                ans++;
            }
        }

        return ans;
    }
}
