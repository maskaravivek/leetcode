// https://leetcode.com/problems/find-mode-in-binary-search-tree/
package leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[] {};
        }
        if (root.left == null && root.right == null) {
            return new int[] { root.val };
        }
        Map<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        queue.addAll(map.keySet());

        int max = map.get(queue.peek());

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty() && map.get(queue.peek()) == max) {
            result.add(queue.poll());
        }

        int[] res = new int[result.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;

    }

    public void inOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        inOrder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inOrder(root.right, map);
    }
}
// @lc code=end
