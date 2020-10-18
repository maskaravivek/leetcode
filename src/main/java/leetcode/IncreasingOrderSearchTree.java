package leetcode;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newTree = null;
        return inOrder(root, newTree);
    }

    public TreeNode inOrder(TreeNode root, TreeNode tree) {
        if (root == null) {
            return tree;
        }
        TreeNode res = inOrder(root.left, root);
        root.left = null;
        root.right = inOrder(root.right, tree);
        return res;
    }
}