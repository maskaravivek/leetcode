package leetcode;

// https://leetcode.com/problems/find-lucky-integer-in-an-array

import java.util.HashMap;

class FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int largest = -1;
        for(int key: map.keySet()) {
            if(map.get(key) == key && key > largest) {
                largest = key;
            }
        }
        return largest;
    }
}