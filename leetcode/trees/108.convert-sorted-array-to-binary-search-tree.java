// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

package leetcode.trees;
/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

import leetcode.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return makeTree(nums, 0, nums.length - 1);
    }

    public TreeNode makeTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = makeTree(nums, left, mid - 1);
        node.right = makeTree(nums, mid + 1, right);
        return node;
    }
}
// @lc code=end
