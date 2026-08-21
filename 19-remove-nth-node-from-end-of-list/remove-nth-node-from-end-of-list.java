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
        int sz=0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){
            return head.next;
        }
        //int i=1;
        //int range=sz-n;
        ListNode prev=head;
        for(int i=1;i<sz-n;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}