// https://leetcode.com/problems/n-ary-tree-postorder-traversal

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostOrderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> tree = new ArrayList<>();
        postOrder(root, tree);
        return tree;
    }

    public void postOrder(Node root, List<Integer> tree) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            postOrder(child, tree);
        }
        tree.add(root.val);
    }
}