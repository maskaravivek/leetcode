package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] hist = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            hist[i] = matrix[0][i] - '0';
        }

        maxArea = Math.max(maxArea, largestRectangleArea(hist));
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    hist[j] = 0;
                } else {
                    hist[j] += 1;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(hist));
        }

        return maxArea;
    }

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
