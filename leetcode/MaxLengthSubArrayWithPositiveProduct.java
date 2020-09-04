// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product

package leetcode;

public class MaxLengthSubArrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int max = 0;
        int firstNegativeIndex = -1;
        int zeroIndex = -1;
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
                if (firstNegativeIndex == -1) {
                    firstNegativeIndex = i;
                }
            }

            if (nums[i] == 0) {
                negativeCount = 0;
                firstNegativeIndex = -1;
                zeroIndex = i;
            } else {
                if (negativeCount % 2 == 0) {
                    max = Math.max(i - zeroIndex, max);
                } else {
                    max = Math.max(i - firstNegativeIndex, max);
                }
            }
        }
        return max;
    }
}