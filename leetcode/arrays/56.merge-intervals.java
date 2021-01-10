package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class MergeIntervals {

    public static void main(final String[] args) throws java.lang.Exception {
        int[][] res = merge(new int[][] { { 1, 4 }, { 0, 4 } });
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public static int[][] merge(int[][] intervals) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> intervals[a][0] - intervals[b][0]);

        for (int i = 0; i < intervals.length; i++) {
            queue.add(i);
        }

        int[] indexes = new int[intervals.length];

        int idx = 0;
        while (!queue.isEmpty()) {
            indexes[idx++] = queue.poll();
        }

        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            int start = intervals[indexes[i]][0];
            int end = intervals[indexes[i]][1];

            if (i + 1 < indexes.length) {
                i = i + 1;
                while (i < indexes.length && intervals[indexes[i]][0] <= end) {
                    if (intervals[indexes[i]][1] > end) {
                        end = intervals[indexes[i]][1];
                    }
                    i = i + 1;
                }
                i -= 1;
            }

            results.add(new int[] { start, end });
        }

        int[][] res = new int[results.size()][];

        for (int i = 0; i < results.size(); i++) {
            res[i] = results.get(i);
        }

        return res;
    }
}
// @lc code=end
