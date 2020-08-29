// https://leetcode.com/problems/number-of-islands/

package leetcode.graphs;

public class NumberOfIslands {
    int[] dr = new int[] { 1, 0, -1, 0 };
    int[] dc = new int[] { 0, 1, 0, -1 };

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '2';

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                    && grid[newRow][newCol] == '1') {
                dfs(grid, newRow, newCol);
            }
        }
    }
}