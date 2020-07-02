// https://leetcode.com/problems/minimum-distance-between-bst-nodes

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinDiffInBST {

    public int minDiffInBST(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        inOrder(root, tree);
        Collections.sort(tree);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < tree.size() - 1; i++) {
            minDiff = Math.min(minDiff, Math.abs(tree.get(i) - tree.get(i + 1)));
        }
        return minDiff;
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