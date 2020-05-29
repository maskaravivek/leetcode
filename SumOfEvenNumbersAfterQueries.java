// https://leetcode.com/problems/sum-of-even-numbers-after-queries

class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        
        for(int i=0; i< A.length; i++) {
            if(A[i]%2==0) {
                sum+=A[i];
            }
        }
        
        int sums[] = new int[queries.length];
        for(int i=0; i< queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];
            
            if(A[idx] %2==0) {
                sum-=A[idx];
            }
            
            A[idx]+= val;
            if(A[idx] %2==0) {
                sum+=A[idx];
            }
            
            sums[i] = sum;
        }
        return sums;
    }
}