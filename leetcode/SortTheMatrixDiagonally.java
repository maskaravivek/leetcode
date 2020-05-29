// https://leetcode.com/problems/sort-the-matrix-diagonally

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortTheMatrixDiagonally {

    public static void main(final String[] args) throws java.lang.Exception {
        int[][] arr = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        diagonalSort(arr);
    }

    public static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int ridx = 0, cidx = 0, didx = 0;
        for (int i = m - 1; i >= 0; i--) {
            ridx = i;
            cidx = 0;
            List<Integer> diagonal = new ArrayList();
            while (cidx < n && ridx < m) {
                diagonal.add(mat[ridx++][cidx++]);
            }
            Collections.sort(diagonal);

            ridx = i;
            cidx = 0;
            didx = 0;
            while (cidx < n && ridx < m) {
                mat[ridx++][cidx++] = diagonal.get(didx++);
            }
        }

        ridx = 0; cidx = 0; didx = 0;
        for (int i = 1; i < n; i++) {
            ridx = 0;
            cidx = i;
            List<Integer> diagonal = new ArrayList();
            while (cidx < n && ridx < m) {
                diagonal.add(mat[ridx++][cidx++]);
            }
            Collections.sort(diagonal);

            ridx = 0;
            cidx = i;
            didx = 0;
            while (cidx < n && ridx < m) {
                mat[ridx++][cidx++] = diagonal.get(didx++);
            }
        }
        return mat;
    }
}