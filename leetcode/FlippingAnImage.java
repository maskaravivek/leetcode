package leetcode;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] flipped = new int[A[0].length][A.length];
        
        int len = A[0].length;
        for(int i=0; i<A.length; i++) {
            for(int j=len -1; j>=0; j--) {
                flipped[i][len -1 - j] = A[i][j] == 1? 0: 1;
            }
        }
        return flipped;
    }
}