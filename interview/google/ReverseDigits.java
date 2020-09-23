package interview.google;

import java.util.HashMap;
import java.util.Map;

public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 20, 2, 11}));
    }

    public static int solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] - rev(arr[i]);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int res = 0;
        for (Integer val : map.values()) {
            res += (val * (val + 1)) / 2;
        }
        return res;
    }

    public static int rev(int num) {
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }

        while (rev % 10 == 0) {
            rev /= 10;
        }
        return rev;
    }
}