// https://leetcode.com/problems/subtree-of-another-tree

package leetcode.trees;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    public boolean traverse(TreeNode s, TreeNode t) {
        if (checkEqual(s, t)) {
            return true;
        } else {
            boolean left = false, right = false;
            
            if(s.left!=null) {
                left = traverse(s.left, t);
            }
            if(s.right!=null) {
                right = traverse(s.right, t);
            }
            
            return left || right;
        }
    }

    public boolean checkEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && checkEqual(s.left, t.left) && checkEqual(s.right, t.right);
    }
}
// @lc code=end
