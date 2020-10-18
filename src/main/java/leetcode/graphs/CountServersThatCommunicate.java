// https://leetcode.com/problems/count-servers-that-communicate

package leetcode.graphs;

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int rc[] = new int[grid.length];
        int cc[] = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rc[i]++;
                    cc[j]++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                if(rc[i]> 1 || cc[j]> 1) {
                    result++;
                }
            }
        }
        return result;
    }
}