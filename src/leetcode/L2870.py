from typing import List
from collections import Counter


# 2870. Minimum Number of Operations to Make Array Empty
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        c = Counter(nums)
        res = 0
        for count in c.values():
            if count == 1:
                return -1
            if count % 3 == 0:
                res += count // 3
            else:
                res += count // 3 + 1
        return res


s = Solution()
print(s.minOperations(nums = [2,3,3,2,2,4,2,3,4]))
