package leetcode.trees;

// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.Node;

class MaximumDepthOfANAryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Node>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));

        while (!queue.isEmpty()) {
            List<Node> level = queue.poll();
            List<Integer> numbers = new ArrayList<>();
            List<Node> nodes = new ArrayList<>();
            for (Node node : level) {
                numbers.add(node.val);
                for(Node childNode: node.children) {
                    nodes.add(childNode);
                }
            }
            result.add(numbers);
            if (nodes.size() > 0) {
                queue.add(nodes);
            }
        }
        return result.size();
    }
}