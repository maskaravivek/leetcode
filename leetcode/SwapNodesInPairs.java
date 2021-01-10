package leetcode;

//https://leetcode.com/problems/swap-nodes-in-pairs/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = new ListNode(head.next.val);
        ListNode second = new ListNode(head.val);
        first.next = second;
        ListNode swappedList = swapPairs(head.next.next);
        first.next.next = swappedList;
        return first;
    }
}