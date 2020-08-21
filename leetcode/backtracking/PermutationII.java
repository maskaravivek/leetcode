// https://leetcode.com/problems/permutations
// https://leetcode.com/problems/permutations-ii/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(permuteUnique(new int[] { 1, 2, 3 }));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permute(nums, permutations, current, used);
        return permutations;
    }

    public static void permute(int[] nums, List<List<Integer>> permutations, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));

        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }

                current.add(nums[i]);
                used[i] = true;
                permute(nums, permutations, current, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}