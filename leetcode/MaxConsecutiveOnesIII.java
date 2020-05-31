// https://leetcode.com/problems/max-consecutive-ones-iii

package leetcode;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int A[], int K) {
        int result = Integer.MIN_VALUE;

        int kUsed = 0;
        int left = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                kUsed++;
            }

            while (kUsed > K && left < A.length) {
                if (A[left] == 0) {
                    kUsed--;
                }
                left++;
            }

            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}