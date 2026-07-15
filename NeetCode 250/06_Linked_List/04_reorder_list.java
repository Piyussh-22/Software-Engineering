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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // count nodes
        int count = 0;
        ListNode tempCount = head;
        while (tempCount != null) {
            count++;
            tempCount = tempCount.next;
        }

        // find split point
        if (count % 2 == 0) {
            count = count / 2;
        } else {
            count = (count / 2) + 1;
        }

        // split the list
        ListNode mainHead = head;
        ListNode tempHead = null;

        for (int i = 1; i < count; i++) {
            mainHead = mainHead.next;
            if (i + 1 == count) {
                tempHead = mainHead.next;
                mainHead.next = null;
            }
        }

        // reverse second half
        ListNode back = null;
        ListNode node = tempHead;
        ListNode front;

        while (node != null) {
            front = node.next;
            node.next = back;
            back = node;
            node = front;
        }

        ListNode secondHead = back;

        // merge two halves
        ListNode first = head;
        ListNode second = secondHead;

        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}
/*
143. Reorder List
Solved
        Medium
Topics
premium lock icon
        Companies
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
        1 <= Node.val <= 1000 */