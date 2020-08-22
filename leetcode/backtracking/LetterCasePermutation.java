// https://leetcode.com/problems/letter-case-permutation

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String S) {
        Set<String> results = new HashSet<>();
        backtrack(results, S.toCharArray(), 0, "");
        return new ArrayList<>(results);
    }

    public static void backtrack(Set<String> results, char arr[], int position, String current) {
        if (current.length() >= arr.length) {
            results.add(current);
            return;
        }

        for (int i = position; i < arr.length; i++) {
            int val = (int) arr[i];
            if (val >= 97 && val <= 122) {
                current += Character.toUpperCase(arr[i]);
                backtrack(results, arr, i + 1, current);
                current = current.substring(0, current.length() - 1);
            } else if (val >= 65 && val <= 90) {
                current += Character.toLowerCase(arr[i]);
                backtrack(results, arr, i + 1, current);
                current = current.substring(0, current.length() - 1);
            }
            current += arr[i];
            backtrack(results, arr, i + 1, current);
        }
    }
}