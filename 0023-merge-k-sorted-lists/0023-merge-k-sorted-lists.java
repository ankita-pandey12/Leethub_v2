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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0);
        ListNode curr = ans ;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node : lists){
            if(node!=null)
                pq.add(node);
        }

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            curr.next=new ListNode(smallest.val);
            curr=curr.next;
            if(smallest.next!=null){
                pq.add(smallest.next);
            }
        }
        return ans.next;
    }
}