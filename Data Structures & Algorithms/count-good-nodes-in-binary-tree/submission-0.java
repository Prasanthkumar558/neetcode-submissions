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
    private int goodNodesCount = 0;
    public int goodNodes(TreeNode root) {
        
        countGoodNodes(root,root.val);
        return goodNodesCount;
    }

    public void countGoodNodes(TreeNode root,int maxValue){

        if(root == null){
            return;
        }

        if(root.val >= maxValue){
            maxValue = root.val;
            goodNodesCount += 1;
        }

        if(root.left != null) {
            countGoodNodes(root.left,maxValue);
        }
        if(root.right != null){
            countGoodNodes(root.right,maxValue);
        }

    }
}
