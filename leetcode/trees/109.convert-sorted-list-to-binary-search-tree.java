// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

import leetcode.ListNode;
import leetcode.TreeNode;

/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
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
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return makeTree(list, 0, list.size() - 1);
    }

    private TreeNode makeTree(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(list.get(mid));

        node.left = makeTree(list, left, mid - 1);
        node.right = makeTree(list, mid + 1, right);
        return node;
    }
}
// @lc code=end
