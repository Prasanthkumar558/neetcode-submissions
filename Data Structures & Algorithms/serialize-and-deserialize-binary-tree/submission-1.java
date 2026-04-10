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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder ans = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                ans.append("@ ");
                continue;
            }
            ans.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] array = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        q.add(root);
        for(int i =1;i<array.length;i++){
            TreeNode parent = q.poll();
            if(!array[i].equals("@")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(array[i]));
                parent.left = leftNode;
                q.add(leftNode);
            }
            i++;
           if(!array[i].equals("@")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(array[i]));
                parent.right = rightNode;
                q.add(rightNode);
        }
        }
        return root;
    }
}
