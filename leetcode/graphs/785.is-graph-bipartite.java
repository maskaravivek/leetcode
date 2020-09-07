// https://leetcode.com/problems/is-graph-bipartite/

package leetcode.graphs;

import java.util.LinkedList;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph.length <= 1) {
            return true;
        }
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            colors[i] = -1;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int j = 0; j < graph.length; j++) {
            if (colors[j] != -1) {
                continue;
            }

            queue.add(j);
            colors[j] = 1;

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int i = 0; i < graph[u].length; i++) {
                    if (colors[graph[u][i]] == -1) {
                        colors[graph[u][i]] = 1 - colors[u];
                        queue.add(graph[u][i]);
                    } else if (colors[graph[u][i]] == colors[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end
