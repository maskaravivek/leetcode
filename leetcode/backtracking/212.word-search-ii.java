// https://leetcode.com/problems/word-search-ii/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class WordSearchII {

    int[] dr = new int[] { -1, 0, 1, 0 };
    int[] dc = new int[] { 0, -1, 0, 1 };

    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();

        Map<Character, List<char[]>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i].charAt(0))) {
                map.put(words[i].charAt(0), new ArrayList<>());
            }
            map.get(words[i].charAt(0)).add(words[i].toCharArray());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (map.containsKey(board[i][j])) {
                    for (char[] arr : map.get(board[i][j])) {
                        if (search(board, arr, i, j, 1) && !results.contains(String.valueOf(arr))) {
                            results.add(String.valueOf(arr));
                        }
                    }
                }
            }
        }
        return results;
    }

    private boolean search(char[][] board, char[] arr, int row, int col, int idx) {
        if (idx == arr.length) {
            return true;
        }

        char temp = board[row][col];
        boolean found = false;
        board[row][col] = ' ';
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length
                    && board[newRow][newCol] == arr[idx]) {
                found = found || search(board, arr, newRow, newCol, idx + 1);
            }
        }
        board[row][col] = temp;
        return found;
    }
}
// @lc code=end
