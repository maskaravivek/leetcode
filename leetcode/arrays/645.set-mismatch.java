// https://leetcode.com/problems/set-mismatch/

package leetcode.arrays;

/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int arr[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - 1]++;
        }

        int missing = 0, duplicate = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                duplicate = i + 1;
            }
            if (arr[i] == 0) {
                missing = i + 1;
            }
        }

        return new int[] { duplicate, missing };

    }
}
// @lc code=end
