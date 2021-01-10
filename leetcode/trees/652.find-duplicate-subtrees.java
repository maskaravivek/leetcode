// https://leetcode.com/problems/find-duplicate-subtrees/

package leetcode.trees;

import leetcode.TreeNode;
/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        postorder(root, result, new HashMap<>());
        return result;
    }

    public String postorder(TreeNode node, List<TreeNode> results, Map<String, Integer> map) {
        if (node == null) {
            return "#";
        }

        String serial = node.val + "," + postorder(node.left, results, map) + "," + postorder(node.right, results, map);

        map.put(serial, map.getOrDefault(serial, 0) + 1);

        if (map.get(serial) == 2) {
            results.add(node);
        }
        return serial;
    }
}
// @lc code=end
