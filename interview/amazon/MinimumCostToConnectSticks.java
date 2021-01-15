package interview.amazon;

import java.util.*;

class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a-b);
        
        for(int i=0; i< sticks.length; i++) {
            queue.add(sticks[i]);
        }
        
        int cost = 0;
        while(queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            cost += a + b;
            queue.add(a+b);
        }
        return cost;
    }
}