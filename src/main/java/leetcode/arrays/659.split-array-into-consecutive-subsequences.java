// https://leetcode.com/problems/split-array-into-consecutive-subsequences/

package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 */

// @lc code=start
class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        Map<Integer, Integer> appendFreq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (freq.get(nums[i]) == 0) {
                continue;
            } else if (appendFreq.getOrDefault(nums[i], 0) > 0) {
                appendFreq.put(nums[i], appendFreq.get(nums[i]) - 1);
                appendFreq.put(nums[i] + 1, appendFreq.getOrDefault(nums[i] + 1, 0) + 1);
            } else if (freq.getOrDefault(nums[i] + 1, 0) > 0 && freq.getOrDefault(nums[i] + 2, 0) > 0) {
                freq.put(nums[i] + 1, freq.get(nums[i] + 1) - 1);
                freq.put(nums[i] + 2, freq.get(nums[i] + 2) - 1);
                appendFreq.put(nums[i] + 3, appendFreq.getOrDefault(nums[i] + 3, 0) + 1);
            } else {
                return false;
            }

            freq.put(nums[i], freq.get(nums[i]) - 1);
        }

        return true;
    }
}
// @lc code=end
