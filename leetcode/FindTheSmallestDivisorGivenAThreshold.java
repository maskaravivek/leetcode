// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold
package leetcode;

public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }
        
        right = Math.max(right, threshold);
        int min = 0;
        while (left <= right) {
            int mid = (left + right)/2;
            int res = result(nums, mid);
            
            if (res > threshold) {
                left = mid + 1;
            } else {
                min = mid;
                right = mid - 1;
            }
        }
        return min;
    }

    public int result(int[] nums, int divisor) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res += (nums[i] / divisor) + ((nums[i] % divisor) > 0 ? 1 : 0);
        }

        return res;
    }
}