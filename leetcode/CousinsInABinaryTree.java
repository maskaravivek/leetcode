package leetcode;

// https://leetcode.com/problems/cousins-in-binary-tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class CousinsInABinaryTree {
    public boolean cousinsInABinaryTree(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        int count = 0;
        Queue<Map<Integer, List<TreeNode>>> queue = new LinkedList<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        map.put(count, Arrays.asList(root));
        queue.add(map);

        int xParent = -1, yParent = -1;

        while (!queue.isEmpty()) {
            Map<Integer, List<TreeNode>> level = queue.poll();
            Map<Integer, List<TreeNode>> nextLevelNodes = new HashMap<>();
            for (Integer parent : level.keySet()) {
                List<TreeNode> childNodes = level.get(parent);

                for (TreeNode node : childNodes) {
                    if (node.val == x) {
                        xParent = parent;
                    }
                    if (node.val == y) {
                        yParent = parent;
                    }
                    List<TreeNode> nodes = new ArrayList<>();
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                    nextLevelNodes.put(count++, nodes);
                }
            }
            if (xParent != -1 && yParent != -1 && xParent != yParent) {
                return true;
            } else {
                xParent = -1;
                yParent = -1;
            }
            if (nextLevelNodes.size() > 0) {
                queue.add(nextLevelNodes);
            }
        }

        return false;
    }
}