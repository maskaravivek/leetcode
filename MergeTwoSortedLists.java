// https://leetcode.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        MyLinkedList list = new MyLinkedList();

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.append(l1.val);
                l1 = l1.next;
            } else {
                list.append(l2.val);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            list.append(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            list.append(l2.val);
            l2 = l2.next;
        }

        return list.head;
    }
}