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

    public ListNode reverse(ListNode head){
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;
        while(p != null){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        return q;
    }


    public void reorderList(ListNode head) {
        
        if(head == null || head.next==null || head.next.next==null){
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode reversedHead = reverse(secondHead);

        ListNode temp1 = head;
        ListNode temp2 = reversedHead;

        while(temp2 != null){
            ListNode temp1Next = temp1.next;
            ListNode temp2Next = temp2.next;
            
            temp1.next = temp2;
            temp2.next = temp1Next;

            temp1 = temp1Next;
            temp2 = temp2Next;
        }

    }
}
