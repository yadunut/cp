from typing import List, Optional
from heapq import heappop, heapify


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeLists(self, a, b) -> Optional[ListNode]:
        dummy = ListNode()
        curr = dummy
        while a and b:
            if a.val < b.val:
                curr.next = a
                a = a.next
            else:
                curr.next = b
                b = b.next
            curr = curr.next
        if a:
            curr.next = a
        if b:
            curr.next = b
        return dummy.next

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None
        while len(lists) > 1:
            merged = []
            for i in range(0, len(lists), 2):
                a = lists[i]
                b = lists[i + 1] if i + 1 < len(lists) else None
                merged.append(self.mergeLists(a, b))
            lists = merged
        return lists[0]

    def mergeKListsHeap(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None
        pq = []
        for l in lists:
            curr = l
            while curr:
                pq.append((curr.val, id(curr), curr))
                curr = curr.next

        heapify(pq)
        start = ListNode()
        curr = start
        while pq:
            _, _, node = heappop(pq)
            curr.next = node
            curr = curr.next
        curr.next = None
        return start.next


s = Solution()

r = s.mergeKLists(
    [
        ListNode(1, ListNode(4, ListNode(5))),
        ListNode(1, ListNode(3, ListNode(4))),
        ListNode(2, ListNode(6)),
    ]
)

while r:
    print(r.val)
    r = r.next
