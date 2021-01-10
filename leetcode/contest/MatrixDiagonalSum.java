package leetcode.contest;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int row = 0, col = 0;

        while (row < mat.length && col < mat[0].length) {
            sum += mat[row][col];
            row++;
            col++;
        }

        row = 0;
        col = mat[0].length - 1;

        while (row < mat.length && col >= 0) {
            if (row != col) {
                sum += mat[row][col];
            }

            row++;
            col++;
        }

        return sum;
    }
}
