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
    public boolean hasCycle(ListNode head) {
        
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if(fastPointer == slowPointer){
                return true;
            }
            

        }
     return false;
    }
}
