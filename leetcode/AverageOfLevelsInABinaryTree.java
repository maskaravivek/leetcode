// https://leetcode.com/problems/average-of-levels-in-binary-tree/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInABinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> result = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));

        while (!queue.isEmpty()) {
            List<TreeNode> level = queue.poll();
            double sum = 0.0;
            int count = 0;
            List<TreeNode> nodes = new ArrayList<>();
            for (TreeNode node : level) {
                sum += node.val;
                count++;
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            double avg = 0.0;
            if(count > 0) {
                avg = (double) sum / count;
            }
            result.add(avg);
            if (nodes.size() > 0) {
                queue.add(nodes);
            }
        }
        return result;
    }
}