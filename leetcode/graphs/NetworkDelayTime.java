package leetcode.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = dijkstra(getAdjacencyMatrix(times, N), K, N);
        int max = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(dist));
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    public static int[][] getAdjacencyMatrix(int[][] times, int N) {
        int[][] graph = new int[N + 1][N + 1];
        for (int[] arr : graph) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < times.length; i++) {
            graph[times[i][0]][times[i][1]] = times[i][2];
        }
        print2D(graph);
        return graph;
    }

    public static void print2D(int mat[][]) {
        for (int[] row : mat) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static int[] dijkstra(int graph[][], int source, int N) {
        int dist[] = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
            @Override
            public int compare(Integer c1, Integer c2) {
                return dist[c1] - dist[c2];
            }
        });

        minHeap.offer(source);
        dist[source] = 0;

        while (!minHeap.isEmpty()) {
            int u = minHeap.poll();
            for (int v = 1; v <= N; v++) {
                if (graph[u][v] != Integer.MAX_VALUE && (dist[u] + graph[u][v]) < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    minHeap.offer(v);
                }
            }
        }
        return dist;
    }
}