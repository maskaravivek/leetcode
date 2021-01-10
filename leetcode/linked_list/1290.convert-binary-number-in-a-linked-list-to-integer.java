// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

package leetcode.linked_list;

import leetcode.ListNode;

/*
 * @lc app=leetcode id=1290 lang=java
 *
 * [1290] Convert Binary Number in a Linked List to Integer
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        
        while(head!=null) {
            result = (result << 1) | head.val;
            
            head = head.next;
        }
        
        return result;
    }
}
// @lc code=end

