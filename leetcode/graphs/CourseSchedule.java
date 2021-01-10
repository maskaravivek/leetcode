// https://leetcode.com/problems/course-schedule

package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(final int numCourses, final int[][] prerequisites) {
        final List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // 0: not visited 1: visited 2: visiting
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, i, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int current, int[] visited) {
        if (visited[current] == 2) {
            return true;
        } else if (visited[current] == 1) {
            return false;
        }

        visited[current] = 2;

        List<Integer> nodes = graph.get(current);
        for (Integer node : nodes) {
            if (dfs(graph, node, visited)) {
                return true;
            }
        }

        visited[current] = 1;
        return false;
    }
}