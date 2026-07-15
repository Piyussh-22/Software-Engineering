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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        int value = head.val;
        while(curr != null){
            if(curr.next == null) break;
            if(curr.next.val == value){
                curr.next = curr.next.next;
            }else{
                value = curr.next.val;
                curr = curr.next;
            }
        }
        return head;
    }
}