// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

package interview.amazon;

import java.util.*;

class PairsOfSongsWithDurationDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        for(int i=0; i< time.length; i++) {
            int num = time[i] % 60;
            if(map.containsKey(60 - num)) {
                count+= map.get(60 - num);
            } else if((num == 0 && map.containsKey(0))) {
                count+= map.get(0);
            }
            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}