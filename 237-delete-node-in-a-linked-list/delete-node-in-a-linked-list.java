/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
         node.val = node.next.val;
        ListNode nxt = node.next;
        node.next = nxt.next;
        nxt.next = null;
    }
}