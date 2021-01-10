// https://leetcode.com/problems/search-in-rotated-sorted-array

package leetcode;

public class SearchInARotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (nums[right] >= nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid +1; 
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}