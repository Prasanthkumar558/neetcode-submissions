/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private Node getAllClones(Node node,HashMap<Node,Node> mp){
        Node newNode = new Node(node.val);
        mp.put(node,newNode);

        for(Node neighbor : node.neighbors){

            if(!mp.containsKey(neighbor)){
                newNode.neighbors.add(getAllClones(neighbor,mp));
            }
            else{
                newNode.neighbors.add(mp.get(neighbor));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> mp = new HashMap<>();

        Node ansNode = getAllClones(node,mp);
        return ansNode;
    }
}