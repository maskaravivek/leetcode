package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class TreeFromListsOfList {

    public static void main(final String[] args) throws java.lang.Exception {
        TreeNode root = makeTree(Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, -1, 6, 7)));

        List<List<Integer>> levels = levelOrder(root);
        System.out.println(levels);
    }

    public static TreeNode makeTree(List<List<Integer>> levels) {

        List<List<TreeNode>> nodes = new ArrayList<>();
        for (List<Integer> level : levels) {
            List<TreeNode> levelNodes = new ArrayList<>();
            for (Integer v : level) {
                if (v == -1) {
                    levelNodes.add(null);
                } else {
                    levelNodes.add(new TreeNode(v));
                }
            }
            nodes.add(levelNodes);
        }

        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int j = 0; j < nodes.get(i).size(); j++) {
                TreeNode c = nodes.get(i).get(j);
                if (c != null) {
                    c.left = nodes.get(i + 1).get(2 * j);
                    c.right = nodes.get(i + 1).get(2 * j + 1);
                }
            }
        }

        return nodes.get(0).get(0);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));

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
            result.add(numbers);
            if (nodes.size() > 0) {
                queue.add(nodes);
            }
        }
        return result;
    }
}
