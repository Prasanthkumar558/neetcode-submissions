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

    public ListNode kNode(ListNode temp ,int k){
        int count= 1;
        ListNode knode = temp;
        while(count < k && knode !=null){
            count++;
            knode = knode.next;
        }
        return knode;
    }
    public void reverse(ListNode temp){
        ListNode curr = temp;
        ListNode prev = null;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null){

            ListNode kthNode = kNode(temp,k);
            if(kthNode == null){
                 prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverse(temp);
            if(head == temp){
                head = kthNode;
            }
            else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}
