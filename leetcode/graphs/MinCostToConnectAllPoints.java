package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length - i; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.get(i).add(new int[] { j, dist });
                graph.get(j).add(new int[] { i, dist });
            }
        }

        return minimumSpanningTree(points.length, graph);
    }

    public static int minimumSpanningTree(int N, Map<Integer, List<int[]>> graph) {
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        queue.add(new int[] { 0, 0, 0 });

        int cost = 0;
        while (!queue.isEmpty()) {
            int[] item = queue.poll();

            if (!visited.contains(item[1])) {
                cost += item[2];
                visited.add(item[1]);

                for (int[] adj : graph.get(item[1])) {
                    queue.add(new int[] { item[1], adj[0], adj[1] });
                }
            }
        }

        return visited.size() == N ? cost : -1;
    }
}
