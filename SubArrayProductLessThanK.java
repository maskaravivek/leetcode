// https://leetcode.com/problems/subarray-product-less-than-k/submissions/

class SubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int product = 1, count = 0, leftIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];

            while (product >= k) {
                product /= nums[leftIdx++];
            }
            count += i - leftIdx + 1;
        }
        return count;
    }
}