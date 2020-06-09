// https://leetcode.com/problems/product-of-array-except-self

package leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            left[i] = i - 1 >= 0 ? left[i - 1] * nums[i - 1] : 1;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = (i + 1) <= (nums.length - 1) ? right[i + 1] * nums[i + 1] : 1;
        }

        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}