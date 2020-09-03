// https://leetcode.com/problems/median-of-two-sorted-arrays/

package leetcode.arrays;
/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int idx1 = 0, idx2 = 0, idx = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] <= nums2[idx2]) {
                merged[idx++] = nums1[idx1++];
            } else {
                merged[idx++] = nums2[idx2++];
            }
        }

        while (idx1 < nums1.length) {
            merged[idx++] = nums1[idx1++];
        }

        while (idx2 < nums2.length) {
            merged[idx++] = nums2[idx2++];
        }

        if (merged.length % 2 == 0) {
            return (merged[(merged.length / 2) - 1] + merged[(merged.length / 2)]) / 2.0;
        } else {
            return merged[(merged.length / 2)];
        }
    }
}
// @lc code=end
