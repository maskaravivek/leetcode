package leetcode.interviews;

public class MinCostOfBreakingAChain {
    public int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int p = 1; p < A.length - 1; p++) {
            for (int q = p + 2; q < A.length - 1; q++) {
                min = Math.min(A[p] + A[q], min);
            }
        }
        return min;
    }
}