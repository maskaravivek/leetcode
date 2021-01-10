// https://leetcode.com/problems/beautiful-arrangement

package leetcode.backtracking;
/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class BeautifulArrangement {
    int count = 0;

    public int countArrangement(int N) {
        if (N == 0) {
            return 0;
        }
        helper(1, N, new int[N + 1]);
        return count;
    }

    public void helper(int pos, int N, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] != 1 && ((i % pos == 0) || (pos % i == 0))) {
                used[i] = 1;
                helper(pos + 1, N, used);
                used[i] = 0;
            }
        }
    }
}
// @lc code=end
