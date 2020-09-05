// https://leetcode.com/problems/erect-the-fence/

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=587 lang=java
 *
 * [587] Erect the Fence
 */

// @lc code=start
class Solution {
    public int[][] outerTrees(int[][] points) {
        List<int[]> collinear = new ArrayList<>();

        Set<int[]> result = new HashSet<>();

        int[] start = new int[2];

        start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < start[0]) {
                start = points[i];
            }
        }

        result.add(start);

        int[] current = start;

        while (true) {

            int[] nextTarget = points[0];

            for (int i = 1; i < points.length; i++) {
                if (points[i] == current) {
                    continue;
                }

                int val = crossProduct(current, nextTarget, points[i]);

                if (val > 0) {
                    nextTarget = points[i];
                    collinear = new ArrayList<>();

                } else if (val == 0) {
                    if (distance(current, nextTarget, points[i]) < 0) {
                        collinear.add(nextTarget);
                        nextTarget = points[i];
                    } else {
                        collinear.add(points[i]);
                    }
                }
            }

            for (int[] p : collinear) {
                result.add(p);
            }

            if (nextTarget == start) {
                break;
            }

            result.add(nextTarget);
            current = nextTarget;
        }

        int[][] res = new int[result.size()][];
        int idx = 0;
        for (int[] p : result) {
            res[idx++] = p;
        }
        return res;
    }

    public int crossProduct(int[] a, int[] b, int[] c) {
        int x1 = a[0] - b[0];
        int x2 = a[0] - c[0];
        int y1 = a[1] - b[1];
        int y2 = a[1] - c[1];

        return (y2 * x1) - (x2 * y1);
    }

    public int distance(int[] a, int[] b, int[] c) {
        int x1 = a[0] - b[0];
        int x2 = a[0] - c[0];
        int y1 = a[1] - b[1];
        int y2 = a[1] - c[1];

        return Integer.compare(y1 * y1 + x1 * x2, y2 * y2 + x2 * x2);
    }
}
// @lc code=end
