// https://leetcode.com/problems/unique-paths/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];

        grid[0][0] = 0;
        for(int i=1; i<m; i++) {
            grid[i][0] += grid[i-1][0] + 1;
        }
        
        for(int j=1; j<n;j++) {
            grid[0][j] += grid[0][j-1] + 1;
        }
        
        for(int i = 1; i< m; i++) {
            for(int j =1 ; j< n; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1] + 2;
            }
        }
        return grid[m-1][n-1];
    }
}