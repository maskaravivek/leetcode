package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Statistics {

    public static void main(final String[] args) throws java.lang.Exception {
        solution(new String[][] { { "banana", "90" }, { "apple", "100" }, { "apple", "260" } });
        solution(new String[][] { { "grapefruit", "120" }, { "grape", "200" }, { "grapefruit", "150" },
                { "grapefruit", "150" }, { "grape", "180" } });
        solution(new String[][] { { "apple", "100" }, { "apple", "101" } });
    }

    public static void solution(String[][] arr) {

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i][0])) {
                map.put(arr[i][0], new ArrayList<>());
            }
            map.get(arr[i][0]).add(Integer.parseInt(arr[i][1]));
        }

        TreeMap<String, List<Integer>> results = new TreeMap<>();

        for (String key : map.keySet()) {
            List<Integer> values = map.get(key);

            int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for (Integer val : values) {
                sum += val;
                min = Math.min(min, val);
                max = Math.max(max, val);
            }

            sum = sum / values.size();

            results.put(key, Arrays.asList(min, max, sum));
        }

        for (String key : results.keySet()) {
            List<Integer> val = results.get(key);
            System.out.println(key + " " + val.get(0) + " " + val.get(1) + " " + val.get(2));
        }

    }
}
