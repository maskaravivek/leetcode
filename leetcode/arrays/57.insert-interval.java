package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] allIntervals = new int[intervals.length + 1][];

        for (int i = 0; i < intervals.length; i++) {
            allIntervals[i] = intervals[i];
        }

        allIntervals[allIntervals.length - 1] = newInterval;

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> allIntervals[a][0] - allIntervals[b][0]);

        for (int i = 0; i < allIntervals.length; i++) {
            queue.add(i);
        }

        int[] indexes = new int[allIntervals.length];

        int idx = 0;
        while (!queue.isEmpty()) {
            indexes[idx++] = queue.poll();
        }

        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            int start = allIntervals[indexes[i]][0];
            int end = allIntervals[indexes[i]][1];

            if (i + 1 < indexes.length) {
                i = i + 1;
                while (i < indexes.length && allIntervals[indexes[i]][0] <= end) {
                    if (allIntervals[indexes[i]][1] > end) {
                        end = allIntervals[indexes[i]][1];
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
