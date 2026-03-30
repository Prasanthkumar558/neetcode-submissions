/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }

        Node oldHead = head;
        Node newHead = new Node(head.val);
        HashMap<Node , Node> map = new HashMap<>();
        map.put(head,newHead);

        Node oldTemp = head.next;
        Node newTemp = newHead;

        while(oldTemp != null){
            Node newnode = new Node(oldTemp.val);
            map.put(oldTemp,newnode);
            newTemp.next = newnode;
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
        oldTemp = head;
        newTemp = newHead;
        
        while(oldTemp != null){
            newTemp.random = map.get(oldTemp.random);
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}
