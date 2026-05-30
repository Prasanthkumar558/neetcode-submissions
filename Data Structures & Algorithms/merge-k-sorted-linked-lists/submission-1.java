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
        int val;
        ListNode node;

        Pair(int val,ListNode node){
            this.val = val;
            this.node = node;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));

        for(int i=0;i<lists.length;i++){
            pq.add(new Pair(lists[i].val,lists[i]));
        }

        while(!pq.isEmpty()) {
            Pair obj = pq.poll();
            temp.next = obj.node;
            temp = temp.next;

            if(obj.node.next != null){
                pq.add(new Pair(obj.node.next.val,obj.node.next));
            }
        }
        return dummy.next;
    }
}
