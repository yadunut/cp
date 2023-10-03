package leetcode;

import java.util.HashSet;

public class L141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
    public boolean hasCycleBetter(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next != null ? head.next.next : null;
        while(fast != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        return false;
    }
}
