// https://leetcode.com/problems/construct-string-from-binary-tree/

package leetcode.trees;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        return inOrder(t);
    }

    public String inOrder(TreeNode node) {
        if (node == null) {
            return "";
        } else if(node.left == null && node.right == null) {
            return String.valueOf(node.val);
        }

        String left = "";
        if (node.left == null) {
            left = "()";
        } else {
            left = "(" + inOrder(node.left) + ")";
        }

        String right = "";
        if (node.right == null) {
            right = "";
        } else {
            right = "(" + inOrder(node.right) + ")";
        }

        return node.val + left + right;
    }
}
// @lc code=end
