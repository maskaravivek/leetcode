/*
 * @lc app=leetcode id=667 lang=java
 *
 * [667] Beautiful Arrangement II
 */

// @lc code=start
class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int left = 1;
        int right = n;

        for (int i = 0; i < n; i++) {
            if (k % 2 == 0) {
                result[i] = left++;
            } else {
                result[i] = right--;
            }

            if (k > 1) {
                k--;
            }
        }

        return result;
    }
}
// @lc code=end
