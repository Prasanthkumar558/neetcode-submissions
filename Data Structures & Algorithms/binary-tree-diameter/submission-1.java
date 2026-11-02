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
   int diameter = 0;
    int leftHeight1 = 0;
    int rightHeight1 = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
       int h =  height(root);
        return diameter;
        // return leftHeight1 + rightHeight1 ;
    }

    public int height(TreeNode root){
        
        if(root == null) return 0;

        int leftHeight = height(root.left);
        leftHeight1 = leftHeight;
        int rightHeight = height(root.right);
        rightHeight1 = rightHeight;

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight , rightHeight) +1;
    }
}
 