package leetcode;

//https://leetcode.com/problems/maximum-subarray

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int arr[] = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((arr[i - 1] + nums[i]) > nums[i]) {
                arr[i] = arr[i - 1] + nums[i];
            } else {
                arr[i] = nums[i];
            }
        }

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}