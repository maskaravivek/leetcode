// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.TreeNode;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class SerializeAndDeserializeBinaryTree {

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
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        String str = queue.poll();

        if(str.equals("#")) {
            return null;
        }

        int val = Integer.parseInt(str);

    
        TreeNode node = new TreeNode(val);

        node.left = deserialize(queue);
        node.right = deserialize(queue);

        return node;
    }

    public void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
        } else {
            sb.append(node.val).append(",");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
