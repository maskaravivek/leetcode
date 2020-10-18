// https://leetcode.com/problems/course-schedule-ii

package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer> ordering = findOrder(n, prerequisites);
        List<Boolean> answers = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (prerequisites.length == 0) {
                answers.add(false);
            } else {
                answers.add(ordering.indexOf(queries[i][0]) > ordering.indexOf(queries[i][1]));
            }
        }
        return answers;
    }

    public static List<Integer> findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // 0: not visited 1: visited 2: visiting
        int[] visited = new int[numCourses];

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, visited, graph, result)) {
                return new ArrayList<>();
            }
        }

        return result;
    }

    private static boolean dfs(int current, int[] visited, List<List<Integer>> graph, List<Integer> arr) {
        if (visited[current] == 2) {
            return true;
        } else if (visited[current] == 1) {
            return false;
        }

        visited[current] = 2;

        List<Integer> nodes = graph.get(current);

        for (Integer node : nodes) {
            if (dfs(node, visited, graph, arr)) {
                return true;
            }
        }

        visited[current] = 1;
        arr.add(current);
        return false;
    }
}