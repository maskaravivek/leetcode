//https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        MyLinkedList list = new MyLinkedList();
        int carry = 0, rem = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            rem = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
            list.append(rem);
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            rem = sum % 10;
            list.append(rem);
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            rem = sum % 10;
            list.append(rem);
            l2 = l2.next;
        }

        if (carry > 0) {
            list.append(carry);
        }

        return list.head;
    }
}