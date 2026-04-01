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

    public boolean isBalanced(TreeNode root, TreeNode subRoot){
        if(root== null || subRoot == null){
            return root==subRoot;
        }

        boolean leftRoot = isBalanced(root.left ,subRoot.left);
        boolean rightRoot = isBalanced(root.right,subRoot.right);

        return leftRoot && rightRoot && root.val==subRoot.val;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null || subRoot == null){
            return root==subRoot;
        }

        if(root.val == subRoot.val && isBalanced(root,subRoot)){
            return true;
        }
        
        boolean leftTree = isSubtree(root.left,subRoot);
        boolean rightTree = isSubtree(root.right,subRoot);

        return leftTree || rightTree;

    }
}
