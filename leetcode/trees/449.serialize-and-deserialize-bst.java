// https://leetcode.com/problems/serialize-and-deserialize-bst/

package leetcode.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;

/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] elements = data.split(",");

        Queue<String> queue = new LinkedList<>(Arrays.asList(elements));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode deserialize(Queue<String> queue, int lower, int upper) {
        if (queue.isEmpty()) {
            return null;
        }

        String str = queue.peek();

        int val = Integer.parseInt(str);

        if (val < lower || val > upper) {
            return null;
        }

        queue.poll();

        TreeNode node = new TreeNode(val);

        node.left = deserialize(queue, lower, val);
        node.right = deserialize(queue, val, upper);

        return node;
    }

    public void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.val).append(",");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

