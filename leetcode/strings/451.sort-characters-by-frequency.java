package leetcode.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        queue.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            int freq = map.get(c);
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
// @lc code=end
