from typing import List


class Solution:
    # This runs in O(2^n). How do I optimise this? Btw, this is a backtracking solution
    def canPartitionRec(self, nums: List[int]) -> bool:
        sums = sum(nums)
        # if the number is odd, return false
        if sums % 2 == 1:
            return False
        # if you can sum to half of the array somehow, then the sum of the other half must be the target also
        target = sums // 2
        cache = {}

        def rec(sum=0, idx=0):
            if (sum, idx) in cache:
                print('cache hit')
                return cache[(sum, idx)]
            if idx == len(nums):
                cache[(sum, idx)] = False
                return False
            if sum + nums[idx] == target:
                cache[(sum, idx)] = True
                return True
            return rec(sum + nums[idx], idx + 1) or rec(sum, idx + 1)

        return rec()
    def canPartitionSet(self, nums: List[int]) -> bool:
        sums = sum(nums)
        if sums % 2 == 1:
            return False
        target = sums // 2
        cache = set()
        cache.add(0)
        for num in nums:
            tmp = list(cache)
            for val in tmp:
                cache.add(val + num)
        return target in cache


s = Solution()
# print(s.canPartitionSet(nums=[1, 5, 5, 11]))
print(s.canPartitionSet(nums=[100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97]))
