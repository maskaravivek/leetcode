// https://leetcode.com/problems/combinations

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(combine(1, 1));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        backtracking(results, n, k, 1, new ArrayList<>());
        return results;
    }

    public static void backtracking(List<List<Integer>> results, int n, int k, int position, List<Integer> current) {
        if (current.size() >= k) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = position; i <= n; i++) {
            current.add(i);
            backtracking(results, n, k, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}