// https://leetcode.com/problems/maximum-product-subarray/

package leetcode;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], nums[i] * min);
            } else {
                int tmp = max;
                max = Math.max(nums[i], nums[i] * min);
                min = Math.min(nums[i], nums[i] * tmp);
            }

            ans = Math.max(ans, max);
        }

        return ans;
    }
}