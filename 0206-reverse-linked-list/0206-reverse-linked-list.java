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
    public ListNode reverseList(ListNode head) {
        ListNode last = head;
        ListNode prev = null;
        while(last!=null){
            ListNode n = last.next;
            last.next=prev;
            prev=last;
            last=n;
        }
        return prev;
    }
}