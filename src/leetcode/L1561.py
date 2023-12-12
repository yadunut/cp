# 1561. Maximum Number of Coins You Can Get
from typing import List


class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        n = len(piles)
        piles.sort()
        result = 0
        for i in range(n // 3, n, 2):
            result += piles[i]
        return result


s = Solution()
print(s.maxCoins([2, 4, 1, 2, 7, 8]))
print(s.maxCoins([2, 4, 5]))
print(s.maxCoins([9, 8, 7, 6, 5, 1, 2, 3, 4]))
