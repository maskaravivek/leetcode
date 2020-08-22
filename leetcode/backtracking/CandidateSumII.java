// https://leetcode.com/problems/combination-sum-ii

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidateSumII {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(candidates);
        backtracking(results, candidates, new ArrayList<Integer>(), target, 0);
        return results;
    }

    private static void backtracking(List<List<Integer>> results, int[] candidates, List<Integer> current, int remain,
            int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0  && !results.contains(current)) {
            results.add(new ArrayList<>(current));
            return;
        } else {
            for (int i = start; i < candidates.length && candidates[i] <= remain; i++) {
                current.add(candidates[i]);
                backtracking(results, candidates, current, remain - candidates[i], i + 1);
                current.remove(current.size() - 1);
            }
        }

    }
}