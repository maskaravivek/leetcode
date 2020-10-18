package leetcode.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixQueries {

    public static void main(final String[] args) throws java.lang.Exception {
        long [] ans = matrixQueries(3, 4, new int[][] { { 0 }, { 1, 2 }, { 0 }, { 2, 1 }, { 0 }, { 1, 1 }, { 0 } });
        for(int i=0; i< ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    static long[] matrixQueries(int n, int m, int[][] queries) {
        int board[][] = new int[n][m];
        int active[][] = new int[n][m];
        List<Integer> activeRows = new ArrayList<>();
        List<Integer> activeCols = new ArrayList<>();
        for (int i = 0; i < n; i++) { 
            activeRows.add(i);
        }
        for (int i = 0; i < m; i++) { 
            activeCols.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = (i + 1) * (j + 1);
                active[i][j] = 1;
            }
        }
    

        int minRowIdx = 0, minColIdx = 0;
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                answers.add(board[minRowIdx][minColIdx]);
            } else if (queries[i][0] == 1) {
                activeRows.remove(queries[i][1]-1);
                minRowIdx = Collections.min(activeRows);
            } else if (queries[i][0] == 2) {
                activeCols.remove(queries[i][1]-1);
                minColIdx = Collections.min(activeCols);
            }
        }
        long[] arr = new long[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            arr[i] = answers.get(i);
        }
        return arr;
    }
    
    static int min(int board[][], int active[][], List<Integer> activeRows, List<Integer> activeCols) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < activeRows.size(); i++) {
            for (int j = 0; j < activeCols.size(); j++) {
                if (active[activeRows.get(i)][activeCols.get(j)] == 1) {
                    return board[i][j];
                }
            }
        }
        return min;
    }
}