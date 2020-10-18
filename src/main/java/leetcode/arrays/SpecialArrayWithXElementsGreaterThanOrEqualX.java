package leetcode.arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] >= i) {
                    count++;
                }
            }

            if (count == i) {
                return i;
            }
        }
        return -1;
    }
}
