//https://leetcode.com/problems/find-the-town-judge

package leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> candidates = new HashMap<>();
        Set<Integer> trusts = new HashSet<>();

        for (int i = 0; i < trust.length; i++) {
            candidates.put(trust[i][1], candidates.getOrDefault(trust[i][1], 0) + 1);
            trusts.add(trust[i][0]);
        }

        for (Integer key : candidates.keySet()) {
            if (candidates.get(key) == N - 1 && !trusts.contains(key)) {
                return key;
            }
        }

        return -1;
    }
}