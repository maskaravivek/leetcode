package interview.google;

import java.util.HashMap;
import java.util.Map;

class StudentHeightMinimumRows {

    static int solution(Integer[] A) {
        // Your solution goes here.

        Map<Integer, Integer> map = new HashMap<>();

        int rowNum = 1;

        for (int i = 0; i < A.length; i++) {
            boolean handled = false;
            for (Integer key : map.keySet()) {
                if (map.get(key) > A[i]) {
                    map.put(key, A[i]);
                    handled = true;
                }
            }
            if (!handled) {
                map.put(rowNum++, A[i]);
            }
        }

        return map.size();
    }
}