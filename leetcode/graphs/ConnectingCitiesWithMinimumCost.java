package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int N, int[][] connections) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            graph.put(i, new HashMap<>());
        }

        for (int i = 0; i < connections.length; i++) {
            graph.get(connections[i][0] - 1).put(connections[i][1] - 1, connections[i][2]);
            graph.get(connections[i][1] - 1).put(connections[i][0] - 1, connections[i][2]);
        }
        return minimumSpanningTree(N, graph);
    }

    public static int minimumSpanningTree(int N, Map<Integer, Map<Integer, Integer>> graph) {
        boolean[] mst = new boolean[N];

        int[] parent = new int[N];
        int[] key = new int[N];

        for (int i = 0; i < N; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;
        int cost = 0;

        for (int i = 0; i < N - 1; i++) {
            int u = minKey(key, mst);

            mst[u] = true;

            Map<Integer, Integer> adj = graph.get(u);
            for (Integer v : adj.keySet()) {
                if (mst[v] == false && adj.get(v) < key[v]) {
                    key[v] = adj.get(v);
                    parent[v] = u;
                    cost += adj.get(v);
                }
            }
        }
        return cost;
    }

    public static int minKey(int[] key, boolean[] mst) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < key.length; i++) {
            if (mst[i] == false && key[i] < min) {
                min = key[i];
                minIdx = i;
            }
        }

        return minIdx;
    }
}
