// https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/

package algorithms;

public class PrimsMinimumSpanningTree {

    public static void main(final String[] args) throws java.lang.Exception {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        minimumSpanningTree(graph);
    }

    public static void minimumSpanningTree(int[][] graph) {
        boolean[] mst = new boolean[graph.length];

        int[] parent = new int[graph.length];
        int[] key = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < graph.length - 1; i++) {
            int u = minKey(key, mst);

            mst[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0 && mst[v] == false && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        printMST(parent, graph);
    }

    public static void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
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
