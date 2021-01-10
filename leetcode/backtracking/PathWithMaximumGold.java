// https://leetcode.com/problems/path-with-maximum-gold/

package leetcode.backtracking;

public class PathWithMaximumGold {

    static int dr[] = new int[] { -1, 0, 1, 0 };
    static int dc[] = new int[] { 0, -1, 0, 1 };
    static int max = Integer.MIN_VALUE;

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(
                getMaximumGold(new int[][] { { 1, 0, 7 }, { 2, 0, 6 }, { 3, 4, 5 }, { 0, 3, 0 }, { 9, 0, 20 } }));
    }

    public static int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    maxPath(grid, i, j, 0);
                }
            }
        }
        return max;
    }

    public static void maxPath(int[][] grid, int row, int col, int sum) {
        int currentVal = grid[row][col];

        sum += currentVal;
        max = Math.max(max, sum);
        grid[row][col] = 0;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                    && grid[newRow][newCol] != 0) {
                maxPath(grid, newRow, newCol, sum);
            }
        }

        grid[row][col] = currentVal;
    }
}