package leetcode;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepthOfABinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        int depth = 1;
        queue.add(Arrays.asList(root));

        while (!queue.isEmpty()) {
            List<TreeNode> level = queue.poll();
            List<TreeNode> nodes = new ArrayList<>();
            for (TreeNode node : level) {
                if(node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    nodes.add(node.left);
                } 
                if (node.right != null) {
                    nodes.add(node.right);
                } 
            }
            if (nodes.size() > 0) {
                queue.add(nodes);
                depth++;
            }
        }
        return depth;
    }
}