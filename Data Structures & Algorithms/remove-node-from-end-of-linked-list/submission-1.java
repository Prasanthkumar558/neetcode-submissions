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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next == null){
            return null;
        }

        int size = 0;
        ListNode temp = head;
        while(temp != null ){
            size++;
            temp = temp.next;
        }

        if(size == n){
            return head.next;
        }

        int indexToDelete = size - n + 1;
        ListNode nodeToDelete = head;
        ListNode prev = null;
        int i = 1;
        while( i < indexToDelete){
            i++;
            prev = nodeToDelete;
            nodeToDelete = nodeToDelete.next;
        }
        
        prev.next = nodeToDelete.next;
        nodeToDelete.next = null;

        return head;

    }
}
