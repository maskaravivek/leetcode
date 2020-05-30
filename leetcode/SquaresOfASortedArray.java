package leetcode;

import java.util.Arrays;

class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int idx = 0;
        for(int i=0; i<A.length; i++) {
            if(A[idx] <=0) {
                idx++;
            }
        }
        int ans[] = new int[A.length];
        int negativeIdx=idx-1;
        int positiveIdx = idx;
        int ansIdx = 0;
        
        while(negativeIdx >=0 && positiveIdx<A.length) {
            if(A[positiveIdx] > Math.abs(A[negativeIdx])) {
                ans[ansIdx++] = A[negativeIdx] * A[negativeIdx];
                negativeIdx--;
            } else {
                ans[ansIdx++] = A[positiveIdx] * A[positiveIdx];
                positiveIdx++;
            }
        }
        
        while(negativeIdx>=0) {
            ans[ansIdx++] = A[negativeIdx] * A[negativeIdx];
            negativeIdx--;
        }
        
        while(positiveIdx<A.length) {
            ans[ansIdx++] = A[positiveIdx] * A[positiveIdx];
            positiveIdx++;
        }
        return ans;
    }
}