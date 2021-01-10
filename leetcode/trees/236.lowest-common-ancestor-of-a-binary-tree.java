// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
package leetcode.trees;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestorInBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return backTrack(root, p, q);
    }
    
    public TreeNode backTrack(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = backTrack(root.left, p, q);
        TreeNode right = backTrack(root.right, p, q);
        
        if(left!=null && right!= null) {
            return root;
        } 
        
        return left!=null? left: right;
    }
}
// @lc code=end

