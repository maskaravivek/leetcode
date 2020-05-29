// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeZigZagOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));
        int levelCount = 1;
        while (!queue.isEmpty()) {
            List<TreeNode> level = queue.poll();
            List<Integer> numbers = new ArrayList<>();
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
            if(levelCount%2 == 0) {
                Collections.reverse(numbers);
            }
            result.add(numbers);

            levelCount++;
            if (nodes.size() > 0) {
                queue.add(nodes);
            }
        }
        return result;
    }
}