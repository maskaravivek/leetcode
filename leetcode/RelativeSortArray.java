// https://leetcode.com/problems/relative-sort-array

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int freq[] = new int[1001];

        for (int i = 0; i < arr1.length; i++) {
            freq[arr1[i]]++;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++) {
            res.add(arr2[i]);
            while (freq[arr2[i]] > 1) {
                res.add(arr2[i]);
                freq[arr2[i]]--;
            }
            freq[arr2[i]]--;
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                res.add(i);
                freq[i]--;
            }
        }
        int[] n = new int[res.size()];

        Arrays.setAll(n, res::get);
        return n;
    }
}