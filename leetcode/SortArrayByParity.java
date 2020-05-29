// https://leetcode.com/problems/sort-array-by-parity/
class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int startIdx = 0;
        int endIdx = A.length-1;
        int temp =0;
        while(endIdx> startIdx) {
            if(A[startIdx] %2 != 0) {
                temp = A[startIdx];
                A[startIdx] = A[endIdx];
                A[endIdx--] = temp;
            } else {
                startIdx++;
            }
        }
        return A;
    }
}