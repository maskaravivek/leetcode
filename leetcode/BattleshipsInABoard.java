// https://leetcode.com/problems/battleships-in-a-board

package leetcode;

public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    boolean left = i - 1 >= 0 ? board[i - 1][j] == '.' : true;
                    boolean up = j - 1 >= 0 ? board[i][j - 1] == '.' ? true : false : true;

                    if (left && up) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}