package interview.amazon;

import java.util.*;

class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< keysPressed.length(); i++) {
            int duration = i==0? releaseTimes[0]: (releaseTimes[i] - releaseTimes[i-1]);
            char key = keysPressed.charAt(i);
            if(!map.containsKey(key) || map.get(key) < duration) {
                map.put(key, duration);
            } 
        }
        
        System.out.println(map);
        
        PriorityQueue<Character> queue = new PriorityQueue<Character>((a, b) -> {
            if(map.get(b)!=map.get(a)) {
                return map.get(b) - map.get(a);    
            } else {
                return b - a;
            }
            
        });
        
        queue.addAll(map.keySet());
        
        return queue.poll();
    }
}