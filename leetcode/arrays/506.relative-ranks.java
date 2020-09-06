// https://leetcode.com/problems/relative-ranks/
package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=506 lang=java
 *
 * [506] Relative Ranks
 */

// @lc code=start
class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);

        for (int i = 0; i < nums.length; i++) {
            queue.add(i);
        }

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        while (!queue.isEmpty()) {
            map.put(queue.poll(), rank++);
        }

        String[] ranks = new String[nums.length];

        for (int i = 0; i < ranks.length; i++) {
            int r = map.get(i);
            String rankVal = "";
            if (r == 1) {
                rankVal = "Gold Medal";
            } else if (r == 2) {
                rankVal = "Silver Medal";
            } else if (r == 3) {
                rankVal = "Bronze Medal";
            } else {
                rankVal = String.valueOf(r);
            }
            ranks[i] = rankVal;
        }
        return ranks;
    }
}
// @lc code=end
