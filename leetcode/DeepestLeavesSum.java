package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));

        List<Integer> numbers = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> level = queue.poll();
            numbers.clear();
            List<TreeNode> nodes = new ArrayList<>();
            for (TreeNode node : level) {
                numbers.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            if (nodes.size() > 0) {
                queue.add(nodes);
            }
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        return sum;
    }
}