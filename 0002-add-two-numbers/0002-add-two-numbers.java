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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1= l1;
        ListNode temp2=l2;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int carry=0;
        while(temp1!=null || temp2!=null){
            if(temp1==null){
                int r = temp2.val+carry;
                carry = r/10;
                ListNode t = new ListNode(r%10);
                res.next=t;
                res=res.next;
                temp2=temp2.next;
            }
            else if(temp2==null){
                int r = temp1.val+carry;
                carry = r/10;
                ListNode t = new ListNode(r%10);
                res.next=t;
                res=res.next;
                temp1=temp1.next;
            }
            else{
                int r = temp1.val+temp2.val+carry;
                carry = r/10;
                ListNode t = new ListNode(r%10);
                res.next=t;
                res=res.next;
                temp2=temp2.next;
                temp1=temp1.next;
            }
        }
        if(carry>0){
            ListNode t = new ListNode(carry);
            res.next=t;
            res=res.next;
        }
        return head.next;
    }
}