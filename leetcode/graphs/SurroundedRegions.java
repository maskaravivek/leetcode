// https://leetcode.com/problems/surrounded-regions

package leetcode.graphs;

public class SurroundedRegions {

    int[] dr = new int[] { 1, 0, -1, 0 };
    int[] dc = new int[] { 0, 1, 0, -1 };

    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'X') {
                visited[i][0] = true;
            } else {
                dfs(board, visited, i, 0);
            }
            if (board[i][board[0].length - 1] == 'X') {
                visited[i][board[0].length - 1] = true;
            } else {
                dfs(board, visited, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'X') {
                visited[0][i] = true;
            } else {
                dfs(board, visited, 0, i);
            }
            if (board[board.length - 1][i] == 'X') {
                visited[board.length - 1][i] = true;
            } else {
                dfs(board, visited, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length
                    && board[newRow][newCol] == 'O' && !visited[newRow][newCol]) {
                dfs(board, visited, newRow, newCol);
            }
        }
    }
}