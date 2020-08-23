// https://leetcode.com/problems/n-queens

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtracking(results, board, n, 0);
        return results;
    }

    private boolean backtracking(List<List<String>> results, char[][] board, int n, int col) {
        if (col == n) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                res.add(String.valueOf(board[i]));
            }
            results.add(res);
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, n, i, col)) {
                board[i][col] = 'Q';
                if (backtracking(results, board, n, col + 1)) {
                    return true;
                } else {
                    board[i][col] = '.';
                }
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int n, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != '.' || board[row][i] != '.') {
                return false;
            }
        }

        int step = 1;
        while (row - step >= 0 && col - step >= 0) {
            if (board[row - step][col - step++] != '.') {
                return false;
            }
        }
        step = 1;

        while (row + step < n && col - step >= 0) {
            if (board[row + step][col - step++] != '.') {
                return false;
            }
        }
        return true;
    }
}