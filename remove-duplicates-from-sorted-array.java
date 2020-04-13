// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int uniqueCount = 1, lastNum = nums[0];
        for(int i =1; i< nums.length; i++) {
            if(nums[i-1] != nums[i] && nums[i]!=lastNum) {
                nums[uniqueCount++] = nums[i];
                lastNum = nums[i];
            }
        }
        return uniqueCount;
    }
}