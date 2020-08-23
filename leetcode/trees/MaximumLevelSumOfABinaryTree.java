// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree

package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.TreeNode;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int minLevel = 1, level = 1;

        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));

        while (!queue.isEmpty()) {
            List<TreeNode> nodes = queue.remove();
            List<TreeNode> levelNodes = new ArrayList<>();

            int sum = 0;
            for (TreeNode node : nodes) {
                sum += node.val;
                if (node.left != null) {
                    levelNodes.add(node.left);
                }

                if (node.right != null) {
                    levelNodes.add(node.right);
                }
            }
            if (sum > max) {
                max = sum;
                minLevel = level;
            }
            max = Math.max(max, sum);
            if (!levelNodes.isEmpty()) {
                queue.add(levelNodes);
            }
            level++;
        }
        return minLevel;
    }
}