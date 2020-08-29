// https://leetcode.com/problems/number-of-enclaves

package leetcode.graphs;

public class NumberOfEnclaves {

    int[] dr = new int[] { 1, 0, -1, 0 };
    int[] dc = new int[] { 0, 1, 0, -1 };

    public int numEnclaves(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                visited[i][0] = true;
            } else {
                dfs(A, visited, i, 0);
            }
            if (A[i][A[0].length - 1] == 0) {
                visited[i][A[0].length - 1] = true;
            } else {
                dfs(A, visited, i, A[0].length - 1);
            }
        }

        for (int i = 0; i < A[0].length; i++) {
            if (A[0][i] == 0) {
                visited[0][i] = true;
            } else {
                dfs(A, visited, 0, i);
            }
            if (A[A.length - 1][i] == 0) {
                visited[A.length - 1][i] = true;
            } else {
                dfs(A, visited, A.length - 1, i);
            }
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (!visited[i][j] && A[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] A, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < A.length && newCol < A[0].length && A[newRow][newCol] == 1
                    && !visited[newRow][newCol]) {
                dfs(A, visited, newRow, newCol);
            }
        }
    }
}