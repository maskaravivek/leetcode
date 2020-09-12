// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs
// https://leetcode.com/discuss/interview-question/584289/

package leetcode.trees;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=1530 lang=java
 *
 * [1530] Number of Good Leaf Nodes Pairs
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class NumberOfGoodLeafNodesPairs {
    int result = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }

    public int[] dfs(TreeNode node, int distance) {
        if (node == null) {
            return new int[distance + 1];
        }
        if (node.left == null && node.right == null) {
            int[] res = new int[distance + 1];
            res[1]++;
            return res;
        }

        int[] left = dfs(node.left, distance);
        int[] right = dfs(node.right, distance);

        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                if (i + j <= distance) {
                    result += left[i] * right[j];
                }
            }
        }

        int[] res = new int[distance + 1];
        for (int i = res.length - 2; i >= 1; i--) {
            res[i + 1] = left[i] + right[i];
        }
        return res;
    }
}
// @lc code=end
