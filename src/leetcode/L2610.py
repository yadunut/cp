from typing import List
from collections import Counter, defaultdict


class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        c = Counter(nums)
        res = []
        for i in range(c.most_common(1)[0][1]):
            res.append([])
        for v, count in c.items():
            for i in range(count):
                res[i].append(v)
        return res


s = Solution()
print(s.findMatrix(nums=[1, 3, 4, 1, 2, 3, 1]))
