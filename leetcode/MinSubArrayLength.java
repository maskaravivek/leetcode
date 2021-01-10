// https://leetcode.com/problems/minimum-size-subarray-sum/

package leetcode;

class MinSubArrayLength {
    public int minSubArrayLen(int s, int[] nums) {
        int currentSum = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            while (currentSum >= s) {
                int len = i - left + 1;
                min = Math.min(min, len);
                currentSum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}