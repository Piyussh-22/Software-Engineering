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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        k = k % count;
        if (k == 0) return head;

        int steps = count - k - 1;
        ListNode newTail = head;

        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = head;
        newTail.next = null;

        return newHead;
    }
}