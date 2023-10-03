package leetcode;

public class L206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode next = head.next;
        head.next = null;
        while(next != null) {
            ListNode future = next.next;
            next.next = curr;
            curr = next;
            next = future;
        }
        return curr;
    }
}
