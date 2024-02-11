from typing import List


# 1685. Sum of Absolute Differences in a Sorted Array
class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefixSum = [nums[0]] * n
        for i in range(1, n):
            prefixSum[i] = prefixSum[i - 1] + nums[i]

        suffixSum = [nums[-1]] * n
        for i in range(n - 2, -1, -1):
            suffixSum[i] = suffixSum[i + 1] + nums[i]
        result = []
        for i in range(n):
            r = nums[i] * i
            if i > 0:
                r -= prefixSum[i - 1]
            if i + 1 < n:
                r += suffixSum[i + 1]
            r -= nums[i] * (n - i - 1)
            result.append(r)
        return result


s = Solution()
print(s.getSumAbsoluteDifferences([2, 3, 5]))
print(s.getSumAbsoluteDifferences([1, 4, 6, 8, 10]))
