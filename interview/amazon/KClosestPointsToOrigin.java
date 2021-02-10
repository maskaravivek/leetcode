// https://leetcode.com/problems/k-closest-points-to-origin/
package interview.amazon;

import java.util.*;

class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            double dist1 = Math.sqrt(a[0]*a[0] + a[1]*a[1]);
            double dist2 = Math.sqrt(b[0]*b[0] + b[1]*b[1]);
            
            return dist1 < dist2? -1 : 1;
        });
        
        for(int[] point: points) {
            queue.add(point);
        }
        
        int[][] results = new int[K][2];
        int idx = 0;
        while(idx < K) {
            results[idx++] = queue.poll();
        }
        
        return results;
    }
}