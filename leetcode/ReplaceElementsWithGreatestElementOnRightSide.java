package leetcode;

// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = arr[len-1];
        arr[len-1] = -1;
        for(int i=len-2; i>=0; i--) {
            int newMax = arr[i] > max? arr[i]: max;
            arr[i] = max;
            max = newMax;
        }
        return arr;
    }
}