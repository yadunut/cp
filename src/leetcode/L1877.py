from typing import List


# 1877. Minimize Maximum Pair Sum in Array
class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        res = 0
        for i in range(len(nums) // 2):
            res = max(res, nums[i] + nums[-i - 1])
        return res


s = Solution()
print(s.minPairSum([3, 5, 2, 3]))
print(s.minPairSum([3, 5, 4, 2, 4, 6]))
print(s.minPairSum([4, 1, 5, 1, 2, 5, 1, 5, 5, 4]))
