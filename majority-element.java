import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for(int i =0;i< nums.length; i++) {
            int num = nums[i];
            if(counts.get(num)==null) {
                counts.put(num, 1);
            } else {
                int count  = counts.get(num) + 1;
                counts.put(num, count);
            }
        }
        
        int maxNum = 0, maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(entry.getValue() > maxCount) {
                 maxNum = entry.getKey();
                 maxCount = entry.getValue();
             }
        }
        
        return maxNum;
    }
}