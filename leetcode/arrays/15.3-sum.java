// https://leetcode.com/problems/3sum

package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class ThreeSum {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(threeSum(new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 }));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            result.addAll(twoSum(nums, target, nums[i], i));
        }
        return result;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int num, int i) {
        int start = i + 1;
        int end = nums.length - 1;

        List<List<Integer>> res = new ArrayList<>();
        while (end > start) {
            int sum = nums[start] + nums[end];

            if (sum == target) {
                res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                start++;
                end--;

                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return res;
    }
}
// @lc code=end
