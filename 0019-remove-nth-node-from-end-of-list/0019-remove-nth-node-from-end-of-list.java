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
        int cnt =0;
        ListNode temp = head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        int c = cnt-n;
        if(c==0)
            return head.next;
        ListNode temp1 = head;
        for(int i=0;i<c-1;i++){
            temp1=temp1.next;
        }

        if(temp1.next==null || temp1.next.next==null)
            temp1.next=null;
        else
            temp1.next=temp1.next.next;
        return head;
    }
}