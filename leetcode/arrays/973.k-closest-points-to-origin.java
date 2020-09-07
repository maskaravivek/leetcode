// https://leetcode.com/problems/k-closest-points-to-origin/
package leetcode.arrays;

import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return (Math.pow(a[1], 2) + Math.pow(a[0], 2)) - (Math.pow(b[1], 2) + Math.pow(b[0], 2)) >= 0 ? 1 : -1;
        });

        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
        }

        int idx = 0;
        while (K > 0 && !queue.isEmpty()) {
            result[idx++] = queue.poll();
            K--;
        }

        return result;
    }
}
// @lc code=end
