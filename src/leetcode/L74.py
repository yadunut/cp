from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS = len(matrix)
        COLS = len(matrix[0])
        l, r = 0, ROWS * COLS - 1
        while l <= r:
            mid = (l + r) // 2
            rn, cn = mid // COLS, mid % COLS
            if target == matrix[rn][cn]:
                return True
            if target > matrix[rn][cn]:
                l = mid+1
            if target < matrix[rn][cn]:
                r = mid-1
        return False

s = Solution()
print(s.searchMatrix(matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3))
print(s.searchMatrix(matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13))
