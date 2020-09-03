// https://leetcode.com/problems/next-permutation/

package leetcode.backtracking;

import java.util.Arrays;

/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class NextPermutation {

    public static void main(final String[] args) throws java.lang.Exception {
        nextPermutation(new int[] { 1, 2, 3 });
        nextPermutation(new int[] { 3, 2, 1 });
        nextPermutation(new int[] { 1, 1, 5 });
        nextPermutation(new int[] { 1, 3, 2 });
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int idx = nums.length - 2;

        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }

        if (idx >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[idx]) {
                j--;
            }
            swap(nums, idx, j);
        }

        // get first permutation with idx
        reverse(nums, idx + 1, nums.length - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (j > i) {
            swap(nums, i++, j--);
        }
    }
}
// @lc code=end
