// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();

        int maxArea = 0;
        int i;
        for (i = 0; i < heights.length;) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peekFirst()]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                int area = 0;
                if (stack.isEmpty()) {
                    area = i * heights[top];
                } else {
                    area = heights[top] * (i - stack.peekFirst() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            int area = 0;
            if (stack.isEmpty()) {
                area = i * heights[top];
            } else {
                area = heights[top] * (i - stack.peekFirst() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
// @lc code=end
