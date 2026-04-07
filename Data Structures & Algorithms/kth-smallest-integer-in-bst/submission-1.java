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
    public int prevOrder =0;
    public int kthSmallest(TreeNode root, int k) {

        if(root == null) return -1;

        if(root.left != null){
            int leftAns = kthSmallest(root.left,k);
            if(leftAns != -1) return leftAns;
        }

        if(prevOrder + 1 == k) return root.val;
        prevOrder = prevOrder + 1;

        if(root.right != null) {
            int rightAns = kthSmallest(root.right,k);
            if(rightAns != -1){
                return rightAns;
            }
        }

        return -1;

        // if(root == null){
        //     return -1;
        // }

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty()){
        //     int size = q.size();
        //     for(int i=0;i<size;i++){
        //         TreeNode node = q.poll();
        //         pq.add(node.val);
        //         if(pq.size() > k){
        //             pq.poll();
        //         }
        //         if(node.left != null) q.add(node.left);
        //         if(node.right != null) q.add(node.right);
        //     }

        // }
        // return pq.peek();
    }
}
