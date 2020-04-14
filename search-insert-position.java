// https://leetcode.com/problems/search-insert-position/

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len==0) {
            return 0;
        }
        for(int i =0; i< len; i++) {
            if(target <= nums[i]) {
                return i;
            } else if(target > nums[i] && ((i+1 < len && target < nums[i+1]) || (i+1 == len))) {
                return i+1;
            } 
        }
        return 0;
    }
}