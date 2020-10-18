package leetcode;

// https://leetcode.com/problems/check-if-n-and-its-double-exist/

class CheckIfNAndItsDoubleExists {
    public boolean checkIfExist(int[] arr) {
       int[] elements = new int[2000*2 + 1];
        for(int i=0; i< elements.length; i++) {
            elements[i] = 0;
        }
        for(int i=0; i< arr.length; i++) {
            int idx = arr[i]+2000;
            elements[idx] += 1;
        }
        //Handle special case of 2 zeros
        if(elements[2000] == 2) {
            return true;
        }
        for(int i=0; i< arr.length; i++) {
            int idx = arr[i]+2000;
            int idx2 = arr[i] *2 +2000;
            if(idx!=idx2 && elements[idx] == 1 && elements[idx2] == 1) {
                return true;
            }
        }
        return false;
    }
}