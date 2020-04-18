// https://leetcode.com/problems/merge-sorted-array/

class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nidx = n-1;
        int midx = m-1;
        int idx = n+m-1;
        
        while(nidx >=0 && midx>=0) {
            if(nums1[midx] > nums2[nidx]) {
                nums1[idx--] = nums1[midx --];
            } else {
                nums1[idx--] = nums2[nidx --];
            }
        }
        
        while(nidx >=0) {
            nums1[idx--] = nums2[nidx --];
        }
        
        while(midx >=0) {
            nums1[idx--] = nums1[midx --];
        }
    }
}