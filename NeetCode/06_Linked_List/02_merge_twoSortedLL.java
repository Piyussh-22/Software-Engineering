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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;

        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode tempHead = merged;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                tempHead.next = head1;
                head1 = head1.next;
            }else{
                tempHead.next = head2;
                head2 = head2.next;
            }
            tempHead = tempHead.next;
        }

        if(head1 == null) {
            tempHead.next = head2;
        }else{
            tempHead.next = head1;
        }

        return merged.next;
    }
}


/*
* 21. Merge Two Sorted Lists
Solved
Easy
Topics
premium lock icon
Companies
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.*/