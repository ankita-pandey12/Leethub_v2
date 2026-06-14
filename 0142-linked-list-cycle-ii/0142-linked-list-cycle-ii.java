/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode pos = new ListNode(-1);
        ListNode temp = head;
        while(temp!=null){
            if(hs.contains(temp)){
                pos = temp;
                return pos;
            }
            hs.add(temp);
            temp=temp.next;
        }
        ListNode none = null;
        return none;
    }
}