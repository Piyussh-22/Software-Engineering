class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class reverse_LL2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right) return head;

        ListNode leftSide = null;
        ListNode start = head;

        // move start to left position
        for(int i = 1; i < left; i++){
            leftSide = start;
            start = start.next;
        }

        ListNode temp = start;

        // reverse
        ListNode prev = null;
        ListNode ahead = null;

        for(int j = 0; j <= right - left; j++){
            ahead = start.next;
            start.next = prev;
            prev = start;
            start = ahead;
        }

        // connect left side
        if(leftSide != null){
            leftSide.next = prev;
        } else {
            head = prev;
        }

        // connect right side
        temp.next = start;

        return head;
    }

    // optional testing
    public static void main(String[] args) {

    }
}