from collections import defaultdict
from typing import List


class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        result = 0
        freq = defaultdict(lambda: 0)
        for num in nums:
            r = int(str(num)[::-1])
            freq[num - r] += 1
        # print(freq)
        for num in freq.values():
            result += num * (num - 1) // 2
        return result % (10**9 + 7)


s = Solution()
print(s.countNicePairs([42, 11, 1, 97]))
print(s.countNicePairs([13, 10, 35, 24, 76]))
