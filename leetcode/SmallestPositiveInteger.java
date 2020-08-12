package leetcode;

import java.util.Arrays;

class SmallestPositiveInteger {
    public int solution(int[] A) {
        int arr[] = new int[1000001];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i] > 0) {
                arr[A[i]] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                return arr[i];
            }
        }
        return 1;
    }
}
