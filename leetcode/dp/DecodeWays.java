package leetcode.dp;

import java.util.Arrays;

public class DecodeWays {
    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(numDecodings("1"));
        System.out.println("<---------------->");
        System.out.println(numDecodings("0"));
        System.out.println("<---------------->");
        System.out.println(numDecodings("0"));
        System.out.println("<---------------->");
        System.out.println(numDecodings(""));
        System.out.println(numDecodings("9"));
    }

    public static int numDecodings(String s) {
        if(s.length() < 1) {
            return s.length();
        }
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        int numWays = decode(s, 0, dp);
        return numWays;
    }

    public static int decode(String s, int pointer, int dp[]) {
        if (pointer >= s.length()) {
            return 1;
        }
        if (dp[pointer] != -1) {
            return dp[pointer];
        }
        int numWays = 0;
        int singleChar = Integer.parseInt(String.valueOf(s.charAt(pointer)));
        if (singleChar > 0 && singleChar <= 26) {
            numWays += decode(s, pointer + 1, dp);
        }

        if (pointer + 2 > s.length()) {
            return numWays;
        }
        int doubleChars = Integer.parseInt(s.substring(pointer, pointer + 2));
        
        if (doubleChars > 0 && doubleChars <= 26) {
            numWays += decode(s, pointer + 2, dp);
        }
        dp[pointer] = numWays;
        return numWays;
    }
}