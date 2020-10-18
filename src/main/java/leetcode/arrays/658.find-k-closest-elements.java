package leetcode.arrays;

// https://leetcode.com/problems/find-k-closest-elements/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, Math.abs(arr[i] - x));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int val = map.get(a) - map.get(b);
            if (val == 0) {
                return a - b;
            }
            return val;
        });

        queue.addAll(map.keySet());

        int idx = 0;

        List<Integer> results = new ArrayList<>();

        while (idx < k) {
            results.add(arr[queue.poll()]);
            idx++;
        }

        Collections.sort(results);

        return results;
    }
}
// @lc code=end
