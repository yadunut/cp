from typing import List


# 11. Container With Most Water
class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea = 0
        l, r = 0, len(height) - 1
        while l < r:
            newArea = min(height[l], height[r]) * (r - l)
            maxArea = max(maxArea, newArea)
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return maxArea

s = Solution()
print(s.maxArea([1,8,6,2,5,4,8,3,7]))
