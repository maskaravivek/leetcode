// https://leetcode.com/problems/range-sum-of-bst

package leetcode;

import java.util.ArrayList;
import java.util.List;

class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> tree = new ArrayList<>();
        postOrder(root, tree, L, R);
        int sum = 0;
        for(Integer i : tree) {
            sum+= i;
        }
        return sum;
    }

    public void postOrder(TreeNode root, List<Integer> tree, int L, int R) {
        if (root == null) {
            return;
        }
        if (root.val >= L && root.val <= R) {
            tree.add(root.val);
        }
        postOrder(root.left, tree, L, R);
        postOrder(root.right, tree, L, R);
    }
}