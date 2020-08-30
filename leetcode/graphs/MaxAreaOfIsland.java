// https://leetcode.com/problems/max-area-of-island/

package leetcode.graphs;

public class MaxAreaOfIsland {
    int[] dr = new int[] { 1, 0, -1, 0 };
    int[] dc = new int[] { 0, 1, 0, -1 };

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int row, int col) {
        grid[row][col] = 2;

        int area = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                    && grid[newRow][newCol] == 1) {
                area += dfs(grid, newRow, newCol);
            }
        }
        return area;
    }
}