from functools import cmp_to_key
from typing import List


# 1424. Diagonal Traverse II
def compare(item1: tuple[int, int, int], item2: tuple[int, int, int]) -> int:
    if (item1[0] + item1[1]) != (item2[0] + item2[1]):
        return (item1[0] + item1[1]) - (item2[0] + item2[1])
    return item1[0] - item2[0]


class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        result = []
        for row in range(len(nums)):
            for col in range(len(nums[row])):
                result.append((col, row, nums[row][col]))
        result.sort(key=cmp_to_key(compare))
        # print(result)
        return [v[2] for v in result]


s = Solution()
print(s.findDiagonalOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
print(
    s.findDiagonalOrder(
        [[1, 2, 3, 4, 5], [6, 7], [8], [9, 10, 11], [12, 13, 14, 15, 16]]
    )
)
