package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
class TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        Arrays.sort(nums);

        while (end > start) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[] { start, end };
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[] {};
    }
}