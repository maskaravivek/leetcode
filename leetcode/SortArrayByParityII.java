// https://leetcode.com/problems/sort-array-by-parity-ii

package leetcode;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int mid = A.length / 2;

        int odd[] = new int[mid];
        int even[] = new int[mid];

        int eIdx = 0, oIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even[eIdx] = A[i];
                eIdx++;
            } else {
                odd[oIdx] = A[i];
                oIdx++;
            }
        }

        int res[] = new int[A.length];

        eIdx = 0;
        oIdx = 0;

        for (int i = 0; i < mid; i++) {
            res[i * 2] = even[i];
        }

        for (int i = 1; i <= mid; i++) {
            res[i * 2 - 1] = odd[i -1];
        }

        return res;
    }
}