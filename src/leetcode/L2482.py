from typing import List

# 2482. Difference Between Ones and Zeros in Row and Column
class Solution:
    def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
        rowSum = [sum(row)*2-len(row) for row in grid]
        colSum = [sum(col)*2-len(col) for col in zip(*grid)]
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                grid[row][col] = rowSum[row] + colSum[col]

        return grid
        

s = Solution()
# print(s.onesMinusZeros([[0,1,1],[1,0,1],[0,0,1]]))
print(s.onesMinusZeros([[1,1,1],[1,1,1]]))
