package interview.amazon;

import java.util.*;

class PartitionLabels {
    class Label {
        int startIdx;
        int endIdx;
        
        Label(int s, int e) {
            this.startIdx = s;
            this.endIdx = e;
        }
        
        void setEndIdx(int end) {
            this.endIdx = end;
        }
        
        public String toString() {
            return "["+startIdx+ ", " + endIdx+"]";
        }
    }
    
    public List<Integer> partitionLabels(String S) {
        char[] arr = S.toCharArray();
        
        Map<Character, Label> map = new HashMap<>();
        
        for(int i=0; i< arr.length; i++) {
            char c = arr[i];
            if(!map.containsKey(c)) {
                map.put(c, new Label(i, i));
            }
            
            map.get(c).setEndIdx(i);
        }
        
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> {
            return map.get(a).startIdx - map.get(b).startIdx;
        });
        
        queue.addAll(map.keySet());
        
        List<Integer> partitions = new ArrayList<>();
        int start, end;
        while(!queue.isEmpty()) {
            char c = queue.poll();   
            start = map.get(c).startIdx;
            end = map.get(c).endIdx;
            
            while(!queue.isEmpty()) {
                char nextC = queue.peek();
                if(map.get(nextC).startIdx < end) {
                    queue.poll();
                    end = Math.max(end, map.get(nextC).endIdx);    
                } else {
                    break;
                }
            }
            
            partitions.add(S.substring(start, end + 1).length());
        }
        
        return partitions;
    }
}