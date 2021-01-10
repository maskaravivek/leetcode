package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class SpiralMatrix {

    // right, down, left, up
    static int dr[] = new int[] { 0, 1, -1, 0 };
    static int dc[] = new int[] { 1, 0, 0, -1 };

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));

        System.out.println(spiralOrder(new int[][] { { 1 } }));
        System.out.println(spiralOrder(new int[][] { { 1, 2 } }));
        System.out.println(spiralOrder(new int[][] { { 1 }, { 2 } }));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        // direction 0: right, 1: down, 2: left 3: up
        int current = 0;
        int elements = matrix.length * matrix[0].length;
        int row = 0, col = 0;
        result.add(matrix[0][0]);
        visited[0][0] = true;

        spiral(matrix, result, current, row, col, visited, elements);
        return result;
    }

    public static void spiral(int[][] matrix, List<Integer> result, int current, int row, int col, boolean[][] visited,
            int elements) {
        if (result.size() >= elements) {
            return;
        }
        int newRow = row + dr[current];
        int newCol = col + dc[current];

        if (newRow >= 0 && newCol >= 0 && newCol < matrix[0].length && newRow < matrix.length
                && !visited[newRow][newCol]) {
            result.add(matrix[newRow][newCol]);
            row = newRow;
            col = newCol;
            visited[row][col] = true;
            spiral(matrix, result, current, row, col, visited, elements);
        } else {
            current++;
            if (current > 3) {
                current = 0;
            }

            spiral(matrix, result, current, row, col, visited, elements);
        }
    }
}
// @lc code=end
