// https://leetcode.com/problems/sliding-window-maximum
package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(final String[] args) throws java.lang.Exception {
        maxSlidingWindow(new int[]{}, 5);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int arr[] = new int[nums.length - k + 1];

        int idx = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }

            queue.addLast(i);

            if (i >= k - 1) {
                arr[idx++] = nums[queue.peekFirst()];
            }
        }

        return arr;
    }
}