// https://leetcode.com/problems/path-sum/

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return postOrder(root, sum, 0);
    }

    public boolean postOrder(TreeNode root, int sum, int currentSum) {
        if (root.left == null && root.right == null) {
            return sum == (currentSum + root.val);
        } else if(root.left !=null && root.right == null) {
            return postOrder(root.left, sum, currentSum + root.val);
        } else if(root.right !=null && root.left == null) {
            return postOrder(root.right, sum, currentSum + root.val);
        } else {
            boolean left = postOrder(root.left, sum, currentSum + root.val);
            boolean right = postOrder(root.right, sum, currentSum + root.val);
            return left || right;
        }
    }
}