package interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinByKeyFromDb {
    public Map<String, Integer> minByKey(String key, List<Map<String, Integer>> database) {
        if (database.isEmpty()) {
            return new HashMap<>();
        }
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        int idx = 0;
        for (Map<String, Integer> map : database) {
            if (map.getOrDefault(key, 0) < minVal) {
                minIdx = idx;
                minVal = map.getOrDefault(key, 0);
            }

            idx++;
        }

        return database.get(minIdx);
    }
}
