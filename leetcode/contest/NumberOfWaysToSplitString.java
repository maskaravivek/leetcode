package leetcode.contest;

public class NumberOfWaysToSplitString {
    private static final int m = 1_000_000_007;

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(numWays("10101"));
        System.out.println(numWays("1001"));
        System.out.println(numWays("0000"));
        System.out.println(numWays("100100010100110"));
    }

    public static int numWays(String s) {
        char[] arr = s.toCharArray();
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                cnt++;
            }
        }

        if (cnt == 0) {
            return ((arr.length - 2) * (arr.length - 1) / 2) % 1000000007;
        }

        if (cnt % 3 != 0) {
            return 0;
        }

        int split = cnt / 3;

        int count = 0;
        int waysFirstCut = 0, waysSecondCut = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                count++;
            }

            if (count == split) {
                waysFirstCut++;
            } else if (count == 2 * split) {
                waysSecondCut++;
            }
        }

        return (int)(waysFirstCut * waysSecondCut % m);        
    }
}
