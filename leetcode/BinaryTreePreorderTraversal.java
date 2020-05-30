package leetcode;

// https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList();
        preOrder(root, tree);
        return tree;
    }

    public void preOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        tree.add(root.val);
        preOrder(root.left, tree);
        preOrder(root.right, tree);
    }
}