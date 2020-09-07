// https://leetcode.com/problems/game-of-life/

package leetcode.arrays;

/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {

    int[] dr = new int[] { 1, 0, -1, 0, 1, -1, 1, -1 };
    int[] dc = new int[] { 0, 1, 0, -1, 1, -1, -1, 1 };

    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = 0;
                for (int k = 0; k < 8; k++) {
                    int newRow = i + dr[k];
                    int newCol = j + dc[k];

                    if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length
                            && board[newRow][newCol] == 1) {
                        lives++;
                    }
                }

                if (board[i][j] == 1 && lives < 2) {
                    res[i][j] = 0;
                } else if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
                    res[i][j] = 1;
                } else if (board[i][j] == 1 && lives > 3) {
                    res[i][j] = 0;
                } else if (board[i][j] == 0 && lives == 3) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = board[i][j];
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
}
// @lc code=end
