// https://leetcode.com/problems/number-of-closed-islands/

package leetcode.graphs;

public class NumberOfClosedIslands {
    int[] dr = new int[] { 1, 0, -1, 0 };
    int[] dc = new int[] { 0, 1, 0, -1 };

    public int closedIsland(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                floodFill(grid, visited, i, 0, 1);
            }
            if (grid[i][grid[0].length - 1] == 0) {
                floodFill(grid, visited, i, grid[0].length - 1, 1);
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 0) {
                floodFill(grid, visited, 0, i, 1);
            }
            if (grid[grid.length - 1][i] == 0) {
                floodFill(grid, visited, grid.length - 1, i, 1);
            }
        }

        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    floodFill(grid, visited, i, j, 1);
                }
            }
        }
        return count;
    }

    public int[][] floodFill(int[][] grid, boolean[][] visited, int sr, int sc, int newColor) {
        int startingColor = grid[sr][sc];
        dfs(grid, visited, sr, sc, newColor, startingColor);
        return grid;
    }

    public void dfs(int[][] grid, boolean visited[][], int row, int col, int newColor, int startingColor) {
        grid[row][col] = newColor;
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                    && !visited[newRow][newCol] && grid[newRow][newCol] == startingColor) {
                dfs(grid, visited, newRow, newCol, newColor, startingColor);
            }
        }
    }
}