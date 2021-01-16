// https://leetcode.com/problems/maximum-average-subtree

package interview.amazon;

class MaximumAverageSubtree {
    
    class Pair {
        int count;
        int sum;
        
        Pair(int c, int s) {
            count = c;
            sum = s;
        }
    }
    
    double avg = Double.MIN_VALUE;
    
    public double maximumAverageSubtree(TreeNode root) {
        postOrder(root);
        return avg;
    }
    
    
    public Pair postOrder(TreeNode node) {
        if(node.left==null && node.right == null) {
            avg = Math.max(avg, node.val);
            return new Pair(1, node.val);
        }
        
        Pair left = null, right = null;
        int count = 0, sum = 0;
        if(node.left!=null) {
            left = postOrder(node.left);    
            count += left.count;
            sum+= left.sum;
            
        }
        
        if(node.right !=null) {
            right = postOrder(node.right);    
            count += right.count;
            sum+= right.sum;
        }
        
        count+= 1;
        sum+= node.val;
        
        avg = Math.max(avg, sum/ (count * 1.0));
        
        return new Pair(count, sum);
    }
}
