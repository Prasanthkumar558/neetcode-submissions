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
    public ListNode swapPairs(ListNode head) {
        
        // if(head == null || head.next != null){
        //     return head;
        // }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null){

            ListNode firstNode = prev.next;
            ListNode secondNode = prev.next.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prev.next = secondNode;

            prev = firstNode;
        }

        return dummy.next;
    }
}
