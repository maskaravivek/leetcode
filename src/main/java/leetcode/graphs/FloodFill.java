// https://leetcode.com/problems/flood-fill

package leetcode.graphs;

public class FloodFill {
    int[] dr = new int[] { 1, 0, -1, 0 };
    int[] dc = new int[] { 0, 1, 0, -1 };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean visited[][] = new boolean[image.length][image[0].length];

        int startingColor = image[sr][sc];
        dfs(image, visited, sr, sc, newColor, startingColor);
        return image;
    }

    public void dfs(int[][] image, boolean visited[][], int row, int col, int newColor, int startingColor) {
        image[row][col] = newColor;
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < image.length && newCol < image[0].length && !visited[newRow][newCol]
                    && image[newRow][newCol] == startingColor) {
                dfs(image, visited, newRow, newCol, newColor, startingColor);
            }
        }
    }
}