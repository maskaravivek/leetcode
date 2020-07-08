// https://leetcode.com/problems/binary-tree-inorder-traversal/

package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        inOrder(root, tree);
        return tree;
    }
    
    public void inOrder(TreeNode root, List<Integer> tree) {
        if(root == null) {
            return;
        }
        inOrder(root.left, tree);
        tree.add(root.val);
        inOrder(root.right, tree);
    }
}