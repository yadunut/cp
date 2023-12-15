from typing import Generic, Optional, TypeVar


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
