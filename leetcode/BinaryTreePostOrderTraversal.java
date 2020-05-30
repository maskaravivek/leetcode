package leetcode;

// https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;

class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList();
        postOrder(root, tree);
        return tree;
    }

    public void postOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        postOrder(root.left, tree);
        postOrder(root.right, tree);
        tree.add(root.val);
    }
}