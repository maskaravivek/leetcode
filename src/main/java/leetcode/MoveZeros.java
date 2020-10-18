package leetcode;

// https://leetcode.com/problems/move-zeroes/

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        for(int i = idx; i< nums.length; i++) {
            nums[i] = 0;
        }
    }
}