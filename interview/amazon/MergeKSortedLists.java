package interview.amazon;

import java.util.*;

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b)-> a.val - b.val);
        
        for(ListNode head: lists) {
            if(head!=null) {
                queue.add(head);    
            }
        }
        
        ListNode result = new ListNode();
        ListNode ref = result;
        
        while(!queue.isEmpty()) {
            ListNode min = queue.poll();
            
            result.next = min;
            if(min.next!=null) {
                queue.add(min.next);
            }
            result = result.next;
        }
        
        return ref.next;
    }
}