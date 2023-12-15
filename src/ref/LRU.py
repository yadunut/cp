from typing import Dict, Tuple
from DLL import Node, DLL


class LRU:
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

        if self.cap > len(self.cache):
            # remove smallest element
            r = self.dll.getHead()
            self.dll.remove(r)
            del self.cache[r.val[0]]
