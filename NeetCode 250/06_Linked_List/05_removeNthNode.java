class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0 ;
        ListNode countingTemp = head;
        while(countingTemp != null){
            count++;
            countingTemp = countingTemp.next;
        }
        if(count == n) {
            return head.next;
        }
        int breakPoint = count - n ;
        ListNode temp = head;
        for(int i = 1 ; i < breakPoint ; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}

// one pass

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0 ; i < n ; i++ ){
            fast = fast.next;
        }
        if(fast == null) {
            head = head.next;
            return head;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

// one pass using dummy

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0 ; i < n+1 ; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}