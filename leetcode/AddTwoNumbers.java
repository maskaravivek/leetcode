package leetcode;

//https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class AddTwoNumbers {
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