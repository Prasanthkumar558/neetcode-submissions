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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;

        for(int i=0; i<left-1; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode secondPrev = null;
        ListNode secondHead = curr;

        for(int i=0; i<right-left+1; i++) {
            ListNode temp = curr.next;
            curr.next = secondPrev;
            secondPrev = curr;
            curr = temp;
        }

        prev.next = secondPrev;
        secondHead.next = curr;

        return dummy.next;

    }
}