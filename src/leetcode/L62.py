class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        grid = [[0] * (n + 1)] * (m + 1)
        
        for r in range(m-1, -1, -1):
            for c in range(n-1, -1, -1):
                if c == n-1 and r == m-1:
                    grid[r][c] = 1
                else:
                    grid[r][c] = grid[r+1][c] + grid[r][c+1]
        return grid[0][0]


s = Solution()
print(s.uniquePaths(3, 7))
