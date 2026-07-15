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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                int value = curr.val;
                while(curr.val == value){
                    curr = curr.next;
                    if(curr == null){
                        break;
                    }
                }
                prev.next = curr;
            }else{
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}