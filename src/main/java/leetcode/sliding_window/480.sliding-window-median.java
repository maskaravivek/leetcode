// https://leetcode.com/problems/sliding-window-median/
package leetcode.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class SlidingWindowMedian {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[] { 1, 4, 2, 3 }, 4)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[] { 2147483647, 2147483647 }, 2)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list);

        if (k % 2 == 0) {
            result[0] = ((long) list.get((k / 2) - 1) + (long) list.get(k / 2)) / 2.0;
        } else {
            result[0] = list.get(k / 2);
        }

        for (int i = 1; i <= nums.length - k; i++) {
            list.remove(list.indexOf(nums[i - 1]));
            list.add(nums[k + i - 1]);
            Collections.sort(list);

            if (k % 2 == 0) {
                result[i] = ((long) list.get((k / 2) - 1) + (long) list.get((k / 2))) / 2.0;
            } else {
                result[i] = list.get(k / 2);
            }
        }

        return result;
    }
}
// @lc code=end
