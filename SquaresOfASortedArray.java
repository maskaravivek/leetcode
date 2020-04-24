import java.util.Arrays;

class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int arrayLength = A.length;
        int arr[] = new int[arrayLength];
        for(int i=0; i< A.length; i++) {
            arr[i] = A[i] * A[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}