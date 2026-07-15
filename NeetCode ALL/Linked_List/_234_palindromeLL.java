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
    public boolean isPalindrome(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode dummy  = newHead;
        ListNode curr = head;
        while(curr != null){
            dummy.next = new ListNode(curr.val);
            dummy = dummy.next;
            curr = curr.next;
        }
        newHead = newHead.next;

        // Reverse new LL
        ListNode prev = null;
        ListNode present = newHead;
        while(present != null){
            ListNode ahead = present.next;
            present.next = prev;
            prev = present;
            present = ahead;
        }
        newHead = prev;

        while(head != null){
            if(head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}