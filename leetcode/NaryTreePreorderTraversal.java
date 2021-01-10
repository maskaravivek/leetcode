// https://leetcode.com/problems/n-ary-tree-preorder-traversal/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> tree = new ArrayList<>();
        preorder(root, tree);
        return tree;
    }

    public void preorder(Node root, List<Integer> tree) {
        if (root == null) {
            return;
        }

        tree.add(root.val);
        for (Node child : root.children) {
            preorder(child, tree);
        }
    }
}