/*
 * @lc app=leetcode id=661 lang=java
 *
 * [661] Image Smoother
 */

// @lc code=start
class Solution {
    int[] dr = new int[] { -1, 0, 1, 0, -1, 1, 0, -1, 1 };
    int[] dc = new int[] { 0, -1, 0, 1, -1, 1, 0, 1, -1 };

    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = 0, count = 0;
                for (int k = 0; k < 9; k++) {
                    int newRow = i + dr[k];
                    int newCol = j + dc[k];
                    if (newRow >= 0 && newCol >= 0 && newRow < M.length && newCol < M[0].length) {
                        sum += M[newRow][newCol];
                        count++;
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
// @lc code=end
