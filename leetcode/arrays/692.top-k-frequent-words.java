package leetcode.arrays;

// https://leetcode.com/problems/top-k-frequent-words/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            int freq = map.get(b) - map.get(a);
            if (freq == 0) {
                return a.compareTo(b);
            } else {
                return freq;
            }
        });

        queue.addAll(map.keySet());

        while (result.size() < k) {
            result.add(queue.poll());
        }

        return result;
    }
}
// @lc code=end
