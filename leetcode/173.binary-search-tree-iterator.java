import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTIterator {

    List<Integer> elements = new ArrayList<>();

    int idx = 0;

    public BSTIterator(TreeNode root) {
        inOrder(root, elements);
    }

    public void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }

    /** @return the next smallest number */
    public int next() {
        return elements.get(idx++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return idx < elements.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
// @lc code=end
