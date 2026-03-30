/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    class Pair {
        int key;
        ListNode node;

        Pair(int k,ListNode n){
            key = k;
            node = n;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.key,b.key));

        for(int i=0 ;i<lists.length; i++){
            pq.add(new Pair(lists[i].val,lists[i]));
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(!pq.isEmpty()){
            Pair obj = pq.poll();
            if(obj.node.next != null){
                pq.add( new Pair(obj.node.next.val , obj.node.next));
            }
            temp.next = obj.node;
            temp = temp.next;

        }

        return dummyNode.next;
    }
}
