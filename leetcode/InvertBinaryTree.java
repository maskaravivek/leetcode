// https://leetcode.com/problems/invert-binary-tree/

package leetcode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        return invert(root);
    }

    public TreeNode invert(TreeNode node) {
        TreeNode left = node.left == null? node.left: invert(node.left);
        TreeNode right = node.right == null? node.right: invert(node.right);
        node.left = right;
        node.right = left;

        return node;
    }
}