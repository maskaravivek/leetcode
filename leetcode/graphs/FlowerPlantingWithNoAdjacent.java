// https://leetcode.com/problems/flower-planting-with-no-adjacent
package leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < paths.length; i++) {
            int x = paths[i][0] - 1;
            int y = paths[i][1] - 1;
            map.getOrDefault(x, new HashSet<>()).add(y);
            map.getOrDefault(y, new HashSet<>()).add(x);
        }
        
        int res[] = new int[N];

        for (int i = 0; i < N; i++) {
            int colors[] = new int[5];
            for (int adj : map.get(i)) {
                colors[res[adj]] = 1;
            }

            for (int c = 4; c >= 1; c--) {
                if (colors[c] != 1) {
                    res[i] = c;
                }
            }
        }
        return res;
    }
}