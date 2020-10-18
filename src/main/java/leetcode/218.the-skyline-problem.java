package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < buildings.length; i++) {
            int li = buildings[i][0];
            int ri = buildings[i][1];
            int hi = buildings[i][2];

            points.add(new int[] { li, 0 });
            points.add(new int[] { li, hi });
            points.add(new int[] { ri, 0 });
            points.add(new int[] { ri, hi });
        }

        List<int[]> collinear = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        int[] start = new int[2];

        start = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i)[0] < start[0]) {
                start = points.get(i);
            }
        }

        result.add(Arrays.asList(start[0], start[1]));

        int[] current = start;

        while (true) {

            int[] nextTarget = points.get(0);

            for (int i = 1; i < points.size(); i++) {
                if (points.get(i)== current) {
                    continue;
                }

                int val = crossProduct(current, nextTarget, points.get(i));

                if (val > 0) {
                    nextTarget = points.get(i);
                    collinear = new ArrayList<>();

                } else if (val == 0) {
                    if (distance(current, nextTarget, points.get(i)) < 0) {
                        collinear.add(nextTarget);
                        nextTarget = points.get(i);
                    } else {
                        collinear.add(points.get(i));
                    }
                }
            }

            // for (int[] p : collinear) {
            //     List<Integer> pList = Arrays.asList(p[0], p[1]);
            //     if (!result.contains(pList)) {
            //         result.add(pList);
            //     }
            // }

            if (nextTarget == start) {
                break;
            }

            List<Integer> next = Arrays.asList(nextTarget[0], nextTarget[1]);
            if (!result.contains(next)) {
                result.add(next);
            }

            current = nextTarget;
        }

        return result;
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
