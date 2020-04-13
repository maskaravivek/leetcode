import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle-ii/
class Solution {
    int[][] pascals = new int[34][34];
    public List<Integer> getRow(int rowIndex) {
        for (int i = 0; i < pascals.length; i++) 
        { 
            for (int j = 0; j < pascals[i].length; j++) 
            { 
                pascals[i][j] = -1; 
            } 
        }
        List<Integer> list = new ArrayList<>();
        
        for(int col =0; col<=rowIndex; col++) {
            list.add(pascal(rowIndex, col));
        }
        return list;
    }
    
    public int pascal(int row, int col) {
        if(pascals[row][col] !=-1) {
            return pascals[row][col];
        }
        if(row == col || col == 0) {
            pascals[row][col] = 1;
        } else if(col == 1 || (col + 1) == row) {
            pascals[row][col] = row;
        } else {
            pascals[row][col] = pascal(row-1, col-1) + pascal(row-1, col);
        }
        return pascals[row][col];
    }
}