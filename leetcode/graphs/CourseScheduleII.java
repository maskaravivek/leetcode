// https://leetcode.com/problems/course-schedule-ii

package leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleII {

    public static void main(final String[] args) throws java.lang.Exception {
        int arr[] = findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
        System.out.println(Arrays.toString(arr));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

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
                return new int[] {};
            }
        }

        int res[] = new int[result.size()];
        int idx = 0;
        for (Integer i : result) {
            res[idx++] = i;
        }
        return res;
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