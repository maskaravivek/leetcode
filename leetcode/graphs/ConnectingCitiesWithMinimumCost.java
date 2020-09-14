package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int N, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            graph.get(connections[i][0] - 1).add(new int[] { connections[i][1] - 1, connections[i][2] });
            graph.get(connections[i][1] - 1).add(new int[] { connections[i][0] - 1, connections[i][2] });
        }
        return minimumSpanningTree(N, graph);
    }

    public static int minimumSpanningTree(int N, Map<Integer, List<int[]>> graph) {
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        queue.add(new int[] { 1, 1, 0 });

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
