// method 1 space 0(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);

        ListNode smallTail = smallDummy ;
        ListNode bigTail = bigDummy;

        while(head != null){
            if(head.val >= x){
                bigTail.next = head;
                bigTail = bigTail.next;
            }else{
                smallTail.next = head;
                smallTail = smallTail.next;
            }
            head = head.next;
        }
        smallTail.next = bigDummy.next;
        bigTail.next = null;
        return smallDummy.next;
    }
}

// method 2 space 0(n)
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode dummybig = new ListNode(0);
        ListNode tail = dummy;
        ListNode tailbig = dummybig;
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                ListNode temp = new ListNode(curr.val);
                tail.next = temp;
                tail = tail.next;
            }else{
                ListNode tempbig = new ListNode(curr.val);
                tailbig.next = tempbig;
                tailbig = tailbig.next;
            }
            if(curr.next == null){
                tailbig.next = null;
            }
            curr = curr.next;
        }
        tail.next = dummybig.next;
        return dummy.next;
    }
}