// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
package leetcode.trees;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=1373 lang=java
 *
 * [1373] Maximum Sum BST in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class MaximumSumBSTInBinaryTree {
    class SumNode {
        int min;
        int max;
        int sum;

        public SumNode(int sum, int min, int max) {
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return maxSum;
    }

    public SumNode traverse(TreeNode node) {
        if (node == null) {
            return new SumNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        SumNode left = traverse(node.left);
        SumNode right = traverse(node.right);

        if (!(left != null && right != null && node.val > left.max && node.val < right.min)) {
            return null;
        }

        int sum = node.val + left.sum + right.sum;
        maxSum = Math.max(maxSum, sum);
        int min = Math.min(node.val, left.min);
        int max = Math.max(node.val, right.max);
        return new SumNode(sum, min, max);
    }
}
// @lc code=end
