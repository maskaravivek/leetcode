// https://leetcode.com/problems/largest-perimeter-triangle
package leetcode;

import java.util.Arrays;

class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        
        for (int i = A.length - 3; i >=0; i--) {
            if(isValidTriangle(A[i+2], A[i+1], A[i])) {
                return A[i+2] + A[i+1] + A[i]; 
            }
        }
        return 0;
    }

    public boolean isValidTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}