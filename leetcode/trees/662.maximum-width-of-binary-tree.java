package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = 1;
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));

        while (!queue.isEmpty()) {
            List<TreeNode> current = queue.poll();

            List<TreeNode> levelNodes = new ArrayList<>();
            int count = 0;

            int leftmost = -1, rightmost = -1;

            boolean allNulls = true;

            for (int i = 0; i < current.size(); i++) {
                TreeNode node = current.get(i);

                if (node.left != null) {
                    levelNodes.add(node.left);
                    allNulls = false;
                } else {
                    levelNodes.add(null);
                }

                if (node.right != null) {
                    levelNodes.add(node.right);
                    allNulls = false;
                } else {
                    levelNodes.add(null);
                }

                if (leftmost == -1) {
                    if (node.left != null) {
                        leftmost = i * 2;
                    } else if (node.right != null) {
                        leftmost = i * 2 + 1;
                    }
                }

                if (rightmost == -1) {
                    if (node.right != null) {
                        rightmost = (current.size() - i - 1) * 2;
                    } else if (node.right != null) {
                        rightmost = (current.size() - i - 1) * 2 - 1;
                    }
                }
            }

            max = Math.max(max, rightmost - leftmost);

            if (!allNulls && !levelNodes.isEmpty()) {
                queue.add(levelNodes);
            }

        }
        return max;
    }
}
// @lc code=end
