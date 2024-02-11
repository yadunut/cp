from typing import List


class Solution:
    def trapSlow(self, height: List[int]) -> int:
        n = len(height)
        minLeft = [0] * len(height)
        minRight = [0] * len(height)

        for i in range(1, n, 1):
            minLeft[i] = max(minLeft[i - 1], height[i - 1])
        for i in range(n - 2, -1, -1):
            print(i)
            minRight[i] = max(minRight[i + 1], height[i + 1])
        print(minLeft)
        print(minRight)
        sum = 0
        for i in range(len(height)):
            r = min(minLeft[i], minRight[i]) - height[i]
            sum += r if r > 0 else 0
        return sum

    def trap(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        maxL, maxR = height[l], height[r]
        result = 0
        while l < r:
            if maxL < maxR:
                l += 1
                maxL = max(maxL, height[l])
                result += maxL - height[l]
            else:
                r-=1
                maxR = max(maxR, height[r])
                result += maxR - height[r]
        return result


s = Solution()
print(s.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
