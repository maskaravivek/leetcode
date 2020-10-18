package leetcode;

import java.util.Arrays;

public class DetectPatternOfLengthM {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(containsPattern(new int[] { 1, 2, 1, 2, 1, 1, 1, 3 }, 2, 2));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m; i++) {
            if (pattern(arr, m, k, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean pattern(int arr[], int m, int k, int start) {
        int[] pattern = new int[m];
        String lastPattern = "";
        int count = 0;
        for (int i = start; i <= arr.length - m; i += m) {
            int idx = 0;
            while (idx < m) {
                pattern[idx] = arr[idx + i];
                idx++;
            }

            String key = Arrays.toString(pattern);
            if (lastPattern.equals(key)) {
                count++;
            } else {
                lastPattern = key;
                count = 1;
            }
            if (count >= k) {
                return true;
            }
        }

        return false;
    }
}