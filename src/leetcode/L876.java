package leetcode;

public class L876 {
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        while (head != null && head.next != null) {
            head = head.next.next;
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        L876 s = new L876();
        System.out.println(s.middleNode(ListNode.createNode(new int[]{1, 2, 3, 4, 5, 6})).val);
    }
}
