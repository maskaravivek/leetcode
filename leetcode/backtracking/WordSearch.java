// https://leetcode.com/problems/word-search/

package leetcode.backtracking;

public class WordSearch {

    int dr[] = new int[] { -1, 0, 1, 0 };
    int dc[] = new int[] { 0, -1, 0, 1 };

    public boolean exist(char[][] board, String word) {
        char arr[] = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == arr[0] && search(board, arr, i, j, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, char[] word, int row, int col, int idx) {
        System.out.println(idx + " " + word.length);
        if (idx == word.length) {
            return true;
        }

        char temp = board[row][col];
        boolean found = false;
        board[row][col] = ' ';
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length
                    && board[newRow][newCol] == word[idx]) {
                found = found || search(board, word, newRow, newCol, idx + 1);
            }
        }
        board[row][col] = temp;
        return found;
    }
}