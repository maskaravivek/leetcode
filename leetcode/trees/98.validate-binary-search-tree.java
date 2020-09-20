// https://leetcode.com/problems/validate-binary-search-tree/
package leetcode.trees;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean traverse(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        return node.val > min && node.val < max && traverse(node.left, min, node.val)
                && traverse(node.right, node.val, max);
    }
}
// @lc code=end
