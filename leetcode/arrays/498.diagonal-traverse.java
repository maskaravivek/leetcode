// https://leetcode.com/problems/diagonal-traverse

package leetcode.arrays;

/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[] {};
        }
        int[] result = new int[matrix.length * matrix[0].length];

        int reverse = 1;

        int idx = 0;
        int row = 0, col = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            row = 0;
            col = i;
            int startIdx = idx;
            while (row < matrix.length && col >= 0) {
                result[idx++] = matrix[row][col];
                row++;
                col--;
            }

            if (reverse == 1) {
                reverse(result, startIdx, idx - 1);
                reverse = 0;
            } else {
                reverse = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            row = i;
            col = matrix[0].length - 1;
            int startIdx = idx;
            while (row < matrix.length && col >= 0) {
                result[idx++] = matrix[row][col];
                row++;
                col--;
            }

            if (reverse == 1) {
                reverse(result, startIdx, idx - 1);
                reverse = 0;
            } else {
                reverse = 1;
            }
        }
        return result;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (j > i) {
            swap(nums, i++, j--);
        }
    }
}
// @lc code=end
