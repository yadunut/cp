from collections import defaultdict
from heapq import heappush
from typing import Dict, List, Tuple


class TimeMap:
    def __init__(self):
        self.map: Dict[str, List[Tuple[int, str]]] = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.map[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        ll = self.map[key]
        l, r = 0, len(ll) - 1
        res = ""
        while l <= r:
            mid = (l + r) // 2
            if timestamp < ll[mid][0]:
                r = mid - 1
            elif timestamp >= ll[mid][0]:
                res = ll[mid][1]
                l = mid + 1
            else:
                break
        return res
