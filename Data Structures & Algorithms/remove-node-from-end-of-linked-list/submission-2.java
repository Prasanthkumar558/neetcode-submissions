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
        
       if(head == null) {
        return head;
       }

       int size = 0;
       ListNode tempSize = head;

       while(tempSize != null) {
        size++;
        tempSize = tempSize.next;
       }

       if(size == n) {
        return head.next;
       }

       int intToDelete = size - n + 1;
       ListNode nodeToDelete = head;
       int t = 1;
       ListNode prev = null;

       while(t < intToDelete) {
        t++;
        prev = nodeToDelete;
        nodeToDelete = nodeToDelete.next;
       }

       prev.next = nodeToDelete.next;

       return head;
    }
}
