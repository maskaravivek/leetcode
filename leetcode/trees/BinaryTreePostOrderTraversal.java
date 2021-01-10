// https://leetcode.com/problems/binary-tree-postorder-traversal/

package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
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