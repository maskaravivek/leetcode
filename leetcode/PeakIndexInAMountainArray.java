// https://leetcode.com/problems/peak-index-in-a-mountain-array
package leetcode;

class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (mid > 0 && mid < A.length - 1 && A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }

            if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                left = mid;
            }

            if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                right = mid;
            }
        }
        return -1;
    }
}