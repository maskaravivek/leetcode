// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

package leetcode;

import java.util.ArrayList;
import java.util.List;

class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> tree = new ArrayList<>();
        inOrder(root, tree);
        return tree.get(k - 1);
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