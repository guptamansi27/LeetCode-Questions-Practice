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

        if (left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        // Move curr to left position
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        // Remember the node before left
        ListNode before = prev;
        ListNode start = curr;

        // Reverse from left to right
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // If left is not the first node
        if (before != null) {
            before.next = prev;
        } else {
            head = prev;
        }

        // Connect the end of reversed part
        start.next = curr;

        return head;
    }
}