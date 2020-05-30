
package leetcode;
// https://leetcode.com/problems/valid-mountain-array/

class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int lastVal = A[0];
        int mountain = 0;
        boolean inc = true;
        for (int i = 0; i < A.length; i++) {
            if (inc && A[i] > lastVal) {
                lastVal = A[i];
                mountain = i;
            } else if(inc && lastVal > A[i]) {
                inc = false;
                lastVal = A[i];
            } else if (!inc && lastVal > A[i]) {
                lastVal = A[i];
            } else {
                return false;
            }
        }
        return mountain != 0 && mountain != (A.length - 1);
    }
}