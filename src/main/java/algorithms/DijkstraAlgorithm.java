package algorithms;

public class DijkstraAlgorithm {
    public void dijkstra(int graph[][], int source, int N) {
        int dist[] = new int[N];

        boolean sptSet[] = new boolean[N];

        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[source] = 0;

        for (int count = 0; count < N - 1; count++) {
            int u = minIndex(dist, sptSet, N);
            for (int v = 0; v < N; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && (dist[u] + graph[u][v]) < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
    }

    // Index of unvisited node with minimum distance
    private int minIndex(int[] dist, boolean[] sptSet, int N) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < N; i++) {
            if (sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }
}