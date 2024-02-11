# 146. LRU Cache
from typing import TypeVar, Generic, Optional, Dict, Tuple

T = TypeVar("T")


class Node(Generic[T]):
    def __init__(self, val: T) -> None:
        self.val = val
        self.prev: Optional[Node[T]] = None
        self.next: Optional[Node[T]] = None


class DLL(Generic[T]):
    def __init__(self, val: T) -> None:
        self.head: Node[T] = Node(val)
        self.tail: Node[T] = Node(val)
        self.head.next, self.tail.prev = self.tail, self.head

    def insertTail(self, node: Node[T]):
        assert self.tail.prev
        self.insertAfter(self.tail.prev, node)

    def insertHead(self, node: Node[T]):
        self.insertAfter(self.head, node)

    def insertAfter(self, prev: Node, node: Node[T]):
        next = prev.next
        assert next
        prev.next = next.prev = node
        node.prev, node.next = prev, next

    def remove(self, node: Node[T]):
        prev, next = node.prev, node.next
        assert next
        assert prev
        prev.next, next.prev = next, prev

    def getHead(self) -> Node[T]:
        assert self.head.next
        return self.head.next

    def getTail(self) -> Node[T]:
        assert self.tail.prev
        return self.tail.prev


class LRUCache:
    def __init__(self, capacity: int) -> None:
        self.cap = capacity
        self.cache: Dict[int, Node[Tuple[int, int]]] = {}
        self.dll: DLL[Tuple[int, int]] = DLL((0, 0))

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        res = self.cache[key]
        self.dll.remove(res)
        self.dll.insertTail(res)

        return res.val[1]

    def put(self, key, val):
        if key in self.cache:
            node = self.cache[key]
            node.val = (key, val)
            self.dll.remove(node)
            self.dll.insertTail(node)
            return
        node = Node((key, val))
        self.cache[key] = node
        self.dll.insertTail(node)

        if self.cap < len(self.cache):
            # remove smallest element
            r = self.dll.getHead()
            self.dll.remove(r)
            del self.cache[r.val[0]]

l = LRUCache(2)
l.put(1, 1)
l.put(2, 2)
print(l.get(1))
l.put(3, 3)
print(l.get(2))
l.put(4, 4)
print(l.get(1))
print(l.get(3))
print(l.get(4))
