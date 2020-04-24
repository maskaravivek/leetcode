// https://leetcode.com/problems/remove-element/

class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int deletions = 0, idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            } else {
                deletions++;
            }
        }

        return nums.length - deletions;
    }
}