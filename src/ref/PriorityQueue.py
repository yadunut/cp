from heapq import heappop, heappush
from typing import Dict, Tuple
from dataclasses import dataclass


@dataclass(order=True)
class Entry:
    priority: int
    key: str
    val: str


class PriorityQueue:
    def __init__(self):
        self.map: Dict[str, Entry] = {}
        self.pq = []
        pass

    def push(self, item: Entry) -> None:
        self.map[item.key] = item
        heappush(self.pq, item)

    def pop(self) -> Entry:
        while self.pq[0].val == "REMOVED":
            heappop(self.pq)
        item = heappop(self.pq)
        del self.map[item.key]
        return item

    def peek(self) -> Entry:
        while self.pq[0].val == "REMOVED":
            heappop(self.pq)
        return self.pq[0]

    def popItem(self, key: str):
        self.map[key].val = "REMOVED"
        del self.map[key]

    def changePriority(self, key: str, priority: int):
        oldItem = self.map[key]
        newItem = Entry(priority, key, oldItem.val)
        self.popItem(oldItem.key)
        self.push(newItem)
