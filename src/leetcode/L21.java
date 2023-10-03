package leetcode;


public class L21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        while(list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
                continue;
            }
            if (list1.val < list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        return result.next;
    }
}
