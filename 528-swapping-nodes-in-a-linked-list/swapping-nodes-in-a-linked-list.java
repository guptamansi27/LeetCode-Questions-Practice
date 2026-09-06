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
 //Method 1-With swapping links with values
// class Solution {
//     public ListNode swapNodes(ListNode head, int k) {
//         int size=0;
//         ListNode temp=head;
//         while(temp!=null){
//             temp=temp.next;
//             size++;
//         }
//         ListNode prevX=null,curX=head;
//         for(int i=1;i<k;i++){
//             prevX=curX;
//             curX=curX.next;
//         }

//         ListNode prevY=null,curY=head;
//         for(int i=1;i<size-k+1;i++){
//             prevY=curY;
//             curY=curY.next;
//         }

//         if(curX==null || curY==null)
//             return head;
        
//         if(prevX!=null)
//             prevX.next=curY;
//         else
//             head=curY;

//         if(prevY!=null)
//             prevY.next=curX;
//         else
//             head=curX;
        
//         ListNode t=curX.next;
//         curX.next=curY.next;
//         curY.next=t;

//         return head;
        
//     }
// }
/*Method 2 - only swap values (withput links as per q)
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        // Find kth node from beginning
        ListNode first = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Find kth node from end using two pointers
        ListNode second = head;
        ListNode temp = first;

        // Move temp to the end
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        // Swap values
        int value = first.val;
        first.val = second.val;
        second.val = value;

        return head;
    }
}*/
//Method 3
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        ListNode curX=head,curY=head;
        for(int i=1;i<k;i++){
            curX=curX.next;
        }

        for(int i=1;i<size-k+1;i++){
            curY=curY.next;
        }
        int t=curX.val;
        curX.val=curY.val;
        curY.val=t;

        return head;
    }
}