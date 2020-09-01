// https://leetcode.com/problems/merge-two-binary-trees/

package leetcode.trees;
/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
 */

import leetcode.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return traverse(t1, t2);
    }

    public TreeNode traverse(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode node = new TreeNode(0);
        node.val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);

        if (t1 == null) {
            node.left = t2.left;
        } else if (t2 == null) {
            node.left = t1.left;
        } else {
            node.left = traverse(t1.left, t2.left);
        }

        if (t1 == null) {
            node.right = t2.right;
        } else if (t2 == null) {
            node.right = t1.right;
        } else {
            node.right = traverse(t1.right, t2.right);
        }

        return node;
    }
}
// @lc code=end
