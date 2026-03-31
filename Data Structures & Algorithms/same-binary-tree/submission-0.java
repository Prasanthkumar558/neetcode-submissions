/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null || q == null){
            return p==q;
        }

        boolean leftTreeSame = isSameTree(p.left,q.left);
        boolean rightTreeSame = isSameTree(p.right,q.right);

        return leftTreeSame && rightTreeSame && p.val == q.val;
    }
}
