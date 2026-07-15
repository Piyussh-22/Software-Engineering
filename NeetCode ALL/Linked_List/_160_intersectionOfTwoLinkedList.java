public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        ListNode curr = headA;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }

        int lenB = 0;
        curr = headB;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        ListNode currA = headA;
        ListNode currB = headB;

        if (lenA > lenB) {
            int count = lenA - lenB;
            while (count-- > 0) currA = currA.next;
        } else {
            int count = lenB - lenA;
            while (count-- > 0) currB = currB.next;
        }

        while (currA != null && currB != null) {
            if (currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}
