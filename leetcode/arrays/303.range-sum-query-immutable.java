// https://leetcode.com/problems/range-sum-query-immutable/

package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class RangeSumQueryImmutable {

    List<Integer> arr;

    public RangeSumQueryImmutable(int[] nums) {
        arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int idx = i; idx <= j; idx++) {
            sum += arr.get(idx);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
// @lc code=end
