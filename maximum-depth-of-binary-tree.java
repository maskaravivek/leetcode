// https://leetcode.com/problems/maximum-depth-of-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MaximumDepthOfABinaryTree {
    public int maxDepth(TreeNode root) {
        return depth(root, 1);
    }
    
    public int depth(TreeNode root, int depth) {
        if(root == null) {
            return 0;
        } if(root.left == null && root.right == null) {
            return depth;
        } else if(root.right == null) {
            return depth(root.left, depth + 1);
        } else if(root.left == null) {
            return depth(root.right, depth + 1);
        } else {
            int left = depth(root.left, depth + 1);
            int right = depth(root.right, depth + 1);
            return left > right? left: right;
        }
    }
}