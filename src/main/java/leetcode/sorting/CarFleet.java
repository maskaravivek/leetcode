// https://leetcode.com/problems/car-fleet

package leetcode.sorting;

import java.util.*;

class CarFleeet {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> cars = new TreeMap<Integer, Double>(Collections.reverseOrder());
        
        for(int i=0; i< position.length; i++) {
            cars.put(position[i], ((target- position[i])/(1.0 *speed[i])));
        }
        
        int result = 0;
        double current = 0;
        
        for(double val: cars.values()) {
            if(val > current) {
                result++;
                current = val;
            }
        }
        
        return result;
    }
}