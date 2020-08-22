// https://leetcode.com/problems/combination-sum/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidateSum {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(candidates);
        backtracking(results, candidates, new ArrayList<Integer>(), target, 0);
        return results;
    }

    private static void backtracking(List<List<Integer>> results, int[] candidates, List<Integer> current,
            int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            results.add(new ArrayList<>(current));
            return;
        } else {
            for (int i = start; i < candidates.length && candidates[i] <= remain; i++) {
                current.add(candidates[i]);
                backtracking(results, candidates, current, remain - candidates[i], i);
                current.remove(current.size() - 1);
            }
        }

    }
}