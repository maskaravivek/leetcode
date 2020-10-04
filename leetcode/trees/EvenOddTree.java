// https://leetcode.com/contest/weekly-contest-209/problems/even-odd-tree/

package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        List<List<Integer>> levels = levelOrder(root);

        int idx = 0;
        for (List<Integer> levelNodes : levels) {
            if (idx % 2 == 0) {
                if (!isIncreasing(levelNodes)) {
                    return false;
                }
            } else {
                if (!isDecreasing(levelNodes)) {
                    return false;
                }
            }
            idx++;
        }
        return true;
    }

    public boolean isIncreasing(List<Integer> numbers) {
        int last = numbers.get(0);

        if (last % 2 == 0) {
            return false;
        }

        for (int i = 1; i < numbers.size(); i++) {
            int newNum = numbers.get(i);
            if (newNum % 2 == 0) {
                return false;
            }
            if (newNum > last) {
                last = newNum;
                continue;
            }
            return false;
        }
        return true;
    }

    public boolean isDecreasing(List<Integer> numbers) {
        int last = numbers.get(0);

        if (last % 2 == 1) {
            return false;
        }

        for (int i = 1; i < numbers.size(); i++) {
            int newNum = numbers.get(i);
            if (newNum % 2 == 1) {
                return false;
            }
            if (newNum < last) {
                last = newNum;
                continue;
            }
            return false;
        }
        return true;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
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