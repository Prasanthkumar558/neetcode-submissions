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
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight , rightHeight) + 1;

        // if(root == null){
        //     return 0;
        // }

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // q.add(null);
        // int count = 1;

        // while(!q.isEmpty()){
            
        //     TreeNode node = q.poll();

        //     if(node == null){
        //         if(q.isEmpty()){
        //             break;
        //         }
        //         else{
        //             count++;
        //         }
        //     }
        //     else{
        //         if(node.left != null) q.add(root.left);
        //         if(node.right != null) q.add(root.right);
        //     }
        // }

        // return count;
    }
}
