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

    private Node helper(Map<Node,Node> map,Node node) {
        Node newNode = new Node(node.val);
        map.put(node,newNode);

        for(Node neighbour : node.neighbors) {
            if(!map.containsKey(neighbour)) {
                newNode.neighbors.add(helper(map,neighbour));
            }
            else{
                newNode.neighbors.add(map.get(neighbour));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
       Map<Node,Node> map = new HashMap<>();
       return helper(map,node);
    }
}