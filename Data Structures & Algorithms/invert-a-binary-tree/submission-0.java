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
    public TreeNode invertTree(TreeNode root) {

        if(root == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

        // if(root != null) return root;

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(! q.isEmpty()){

        //     TreeNode node = q.poll();
        //     TreeNode t = node.left;
        //     node.left = node.right;
        //     node.right = t;

        //     if(node.left != null) q.add(node.left);
        //     if(node.right != null) q.add(node.right);
        // }

        // return root;
    }
}
