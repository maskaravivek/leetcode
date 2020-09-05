package leetcode;

import java.util.Arrays;

/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class ReversePairs {
    public int reversePairs(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            int[] arr = Arrays.copyOfRange(nums, i + 1, nums.length);

            Arrays.sort(arr);

            int low = 0;
            int high = arr.length - 1;

            while (low < high) {
                int mid = (low + high) / 2;
                if (nums[i] > 2 * arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            System.out.println(high+" " +low);

            count += (high - low);
        }

        return count;
    }
}
// @lc code=end
