// https://leetcode.com/problems/group-anagrams/

package interview.amazon;

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i< strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            
            int[] counts = new int[26];
            
            for(int j=0; j< arr.length; j++) {
                counts[arr[j] -'a']++;
            }
            
            String representation = Arrays.toString(counts);
            
            if(!map.containsKey(representation)) {
                map.put(representation, new ArrayList<>());
            }
            
            map.get(representation).add(strs[i]);
        }
        
        List<List<String>> results = new ArrayList<>();
        
        for(List<String> result: map.values()) {
            results.add(result);
        }
        return results;
    }
}