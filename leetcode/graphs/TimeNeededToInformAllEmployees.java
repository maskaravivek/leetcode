// https://leetcode.com/problems/time-needed-to-inform-all-employees

package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            if (!graph.containsKey(manager[i])) {
                graph.put(manager[i], new ArrayList<>());
            }
            graph.get(manager[i]).add(i);
        }

        return dfs(graph, informTime, headID);
    }

    public int dfs(Map<Integer, List<Integer>> graph, int[] informTime, int current) {
        int max = 0;
        if (!graph.containsKey(current)) {
            return max;
        }

        for (int i = 0; i < graph.get(current).size(); i++) {
            max = Math.max(max, dfs(graph, informTime, graph.get(current).get(i)));
        }

        return max + informTime[current];
    }
}