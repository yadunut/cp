from typing import Counter, List, Tuple
from heapq import heapify, heappop, heappush, heappushpop

# 621. Task Scheduler
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # convert the tasks to a dict
        c = Counter(tasks)
        pq: List[int] = [-v for v in c.values()]
        heapify(pq)
        q = []
        time = 0
        while pq or q:
            time += 1
            if pq:
                curr = 1 + heappop(pq)
                if curr:
                    q.append((curr, time + n))
            if q and q[0][1] == time:
                heappush(pq, q.pop(0)[0])
        return time

s = Solution()
print(s.leastInterval(tasks=["A", "A", "A", "B", "B", "B"], n=2))
