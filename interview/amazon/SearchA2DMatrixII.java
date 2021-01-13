package interview.amazon;

class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length, cols = matrix[0].length;
        
        int rowIdx = 0, colIdx = 0;
        boolean leftTraversed = false;
        while(rowIdx>=0 && colIdx>=0 && rowIdx < rows && colIdx < cols) {
            if(matrix[rowIdx][colIdx] == target) {
                return true;
            } else if(matrix[rowIdx][colIdx] < target) {
                leftTraversed = true;
                if(colIdx + 1 < cols) {
                    colIdx+=1;    
                } else {
                    leftTraversed = false;
                    rowIdx+=1;
                }
            } else {
                if(leftTraversed) {
                    rowIdx +=1;
                    leftTraversed = false;
                } else {
                    colIdx-=1;
                }
            }
        }
        return false;
    }
}