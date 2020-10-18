// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();

        inOrder(root1, tree1);
        inOrder(root2, tree2);

        List<Integer> tree = new ArrayList<>();

        int idx1 = 0, idx2 = 0;
        while (idx1 < tree1.size() && idx2 < tree2.size()) {
            if (tree1.get(idx1) < tree2.get(idx2)) {
                tree.add(tree1.get(idx1++));
            } else {
                tree.add(tree2.get(idx2++));
            }
        }

        while (idx1 < tree1.size()) {
            tree.add(tree1.get(idx1++));
        }

        while (idx2 < tree2.size()) {
            tree.add(tree2.get(idx2++));
        }
        return tree;
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