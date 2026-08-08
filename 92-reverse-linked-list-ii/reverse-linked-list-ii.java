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
    public ListNode reverseBetween(ListNode head, int l, int r) {

        if (head == null || l == r) {
            return head;
        }

        ListNode left=head;
        ListNode right=head;
        for(int i=1;i<l;i++){
            left=left.next;
        }

        for(int j=1;j<r;j++){
            right=right.next;
        }
        ListNode sp=right.next;

        if (l == 1) {

            right.next = null;

            ListNode prev = left;
            ListNode curr = left.next;

            prev.next = null;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            left.next = sp;

            return right; // or return prev
        }
        ListNode fp=head;

        while(fp.next!=null){
            if(fp.next==left){
                break;
            }
            fp=fp.next;
        }

        fp.next=null;
        right.next=null;



        ListNode prev=left;
        ListNode curr=left;
        curr=curr.next;
        prev.next=null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        left.next=sp;

        fp.next=prev;

        return head;




    }
}