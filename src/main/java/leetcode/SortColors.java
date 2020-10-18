// https://leetcode.com/problems/sort-colors

package leetcode;

public class SortColors {

    public void sortColors(int[] nums) {
        int count[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int idx = count[0] > 0 ? 0 : count[1] > 0 ? 1 : 2;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = idx;
            count[idx]--;
            idx = count[0] > 0 ? 0 : count[1] > 0 ? 1 : 2;
        }
    }
}