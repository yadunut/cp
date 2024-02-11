from typing import List
from collections import defaultdict, deque

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1:
            return [0]
        AL = defaultdict(set)
        deg = [0] * n
        for edge in edges:
            AL[edge[0]].add(edge[1])
            AL[edge[1]].add(edge[0])
            deg[edge[0]] += 1
            deg[edge[1]] += 1
        q = deque()
        for idx, v in enumerate(deg):
            if v == 1:
                q.append(idx)
        print(AL)
        print(q)
        while n > 2:
            currSize = len(q)
            n -= currSize  # remove all elements with deg 1 from n
            for _ in range(currSize):
                curr = q.popleft()
                # go through this items AL and decrease its degree
                for i in AL[curr]:
                    print(curr, ':', i)
                    deg[i] -=1
                    if deg[i] == 1:
                        q.append(i)

        return list(q)


s = Solution()
# print(s.findMinHeightTrees(n=4, edges=[[1, 0], [1, 2], [1, 3]]))
# print(s.findMinHeightTrees(n=6, edges=[[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]]))
print(s.findMinHeightTrees(n=6, edges=[[0, 1], [0, 2], [0, 3], [3, 4], [4, 5]]))
