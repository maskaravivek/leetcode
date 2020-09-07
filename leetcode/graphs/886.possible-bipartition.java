// https://leetcode.com/problems/possible-bipartition/
package leetcode.graphs;

/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N];

        int[][] graph = new int[N + 1][N + 1];

        for (int i = 0; i < dislikes.length; i++) {
            graph[dislikes[i][0] - 1][dislikes[i][1] - 1] = 1;
            graph[dislikes[i][1] - 1][dislikes[i][0] - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int colors[], int index, int color) {
        if (colors[index] != 0) {
            return colors[index] == color;
        }

        colors[index] = color;

        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] == 1 && !dfs(graph, colors, i, -color)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
