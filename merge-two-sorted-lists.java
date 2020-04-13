// https://leetcode.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class MyLinkedList {
    public ListNode head;

    public void append(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);
    }

    public void prepend(int data) {
        ListNode newHead = new ListNode(data);
        newHead.next = head;
        head = newHead;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.val == data) {
            head = head.next;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }
}

class Solution {
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