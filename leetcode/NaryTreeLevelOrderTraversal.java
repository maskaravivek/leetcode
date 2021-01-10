package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Node>> nodes = new LinkedList<>();
        if (root != null) {
            nodes.add(Arrays.asList(root));
        }

        while (!nodes.isEmpty()) {
            List<Node> level = nodes.poll();

            List<Node> nextLevel = new ArrayList<>();
            List<Integer> values = new ArrayList<>();

            for (Node node : level) {
                if (node.children != null && node.children.size() > 0) {
                    for (Node child : node.children) {
                        nextLevel.add(child);
                    }
                }
                values.add(node.val);
            }

            result.add(values);
            if (!nextLevel.isEmpty()) {
                nodes.add(nextLevel);
            }
        }
        return result;
    }
}