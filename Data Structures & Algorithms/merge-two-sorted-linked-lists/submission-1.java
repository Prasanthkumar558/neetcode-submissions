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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
        ListNode list3 = new ListNode(0);
        ListNode last = list3;

        while(list1 != null && list2 != null ){
            if(list1.val <= list2.val){
                last.next = list1;
                list1 = list1.next;
            }
            else{
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }

        while(list1 != null){
            last.next = list1;
            list1 = list1.next;
            last = last.next;
        }

        while(list2 != null){
            last.next = list2;
            list2 = list2.next;
            last = last.next;
        }

        ListNode original = list3.next;
        return original;

    }
}