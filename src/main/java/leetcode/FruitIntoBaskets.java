// https://leetcode.com/problems/fruit-into-baskets
// Think about maximum subarray with at max K distinct elements

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int left = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            while (map.size() > 2) {
                int e = map.get(tree[left]);
                if (e == 1) {
                    map.remove(tree[left]);
                } else {
                    map.put(tree[left], e - 1);
                }
                left++;
            }

            max = Math.max(max, i - left);
        }
        return max;
    }
}