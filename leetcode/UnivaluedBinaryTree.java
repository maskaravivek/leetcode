// https://leetcode.com/problems/univalued-binary-tree/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> tree = new ArrayList<>();
        inOrder(root, tree);
        int first = tree.get(0);
        for (Integer val : tree) {
            if (val != first) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        inOrder(root.left, tree);
        tree.add(root.val);
        inOrder(root.right, tree);
    }
}