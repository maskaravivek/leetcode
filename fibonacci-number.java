import java.util.HashMap;

// https://leetcode.com/problems/fibonacci-number/
class Solution {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int fib(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        int result = 0;
        if (N == 0) {
            result = 0;
        } else if (N == 1) {
            result = 1;
        } else {
            result = fib(N - 1) + fib(N - 2);
        }
        cache.put(N, result);
        return result;
    }
}