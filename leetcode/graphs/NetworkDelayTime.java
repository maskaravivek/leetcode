package leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NetworkDelayTime {
    int sum = 0;

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(i, new HashMap<>());
        }

        for (int i = 0; i < times.length; i++) {
            map.getOrDefault(times[i][0], new HashMap<>()).put(times[i][1], times[i][2]);
        }
        Set<Integer> visited = new HashSet<>();
        visit(map, N, K, visited);
        return sum;
    }

    private void visit(Map<Integer, Map<Integer, Integer>> map, int n, int k, Set<Integer> visited) {
        Map<Integer, Integer> adj = map.get(k);

        for (Integer i : adj.keySet()) {
            if (!visited.contains(i)) {
                visit(map, n, k, visited);
                sum += adj.get(i);
            }
            if (visited.size() == n) {
                return;
            }
        }
    }
}