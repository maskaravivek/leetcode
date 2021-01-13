package interview.amazon;

import java.util.HashSet;

public class UniqueTwoSum {
    public static int uniquePairs(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> set =  new HashSet<>();

        int count = 0;
        for(int num: arr) {
            if(set.contains(target - num) && !seen.contains(num)) {
                count++;
                seen.add(num);
                seen.add(target - num);
            } else if(!set.contains(num)) {
                set.add(num);
            }
        }

        return count;
    }
}
