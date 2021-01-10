// https://leetcode.com/problems/leaf-similar-trees/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        
        inOrder(root1, tree1);
        inOrder(root2, tree2);

        if (tree1.size() != tree2.size()) {
            return false;
        }
        
        int idx = 0;
        while (idx < tree1.size()) {
            if (tree1.get(idx) != tree2.get(idx)) {
                return false;
            }
            idx++;
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        inOrder(root.left, tree);
        if (root.left == null && root.right == null) {
            tree.add(root.val);
        } 
            
        inOrder(root.right, tree);
    }
}