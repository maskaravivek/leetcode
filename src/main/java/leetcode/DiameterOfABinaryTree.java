// https://leetcode.com/problems/diameter-of-binary-tree

package leetcode;

public class DiameterOfABinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}