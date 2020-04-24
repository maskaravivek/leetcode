// https://leetcode.com/problems/climbing-stairs/

import java.util.HashMap;

class ClimbingStairs {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    
    public int climbStairs(int n) {
        return climb(0, n);
    }
    
    public int climb(int current, int n) {
        if(cache.containsKey(current)) {
            return cache.get(current);
        }
        if(current > n) {
            return 0;
        }
        if(current == n) {
            cache.put(current, 1);
            return 1;
        }
        int num = climb(current +1 , n) + climb(current +2, n);
        cache.put(current, num);
        return num;
    }
}