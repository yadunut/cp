from typing import List


class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        left = 0
        currSum = 0
        result = 0
        for right in range(len(nums)):
            currSum += nums[right]
            # if the target is bigger than
            # target is the total value it is supposed to be for everything in this window
            while nums[right] * (right - left + 1) > (currSum + k):
                # print(left)
                currSum -= nums[left]
                left += 1
            result = max(result, right - left + 1)
        return result


s = Solution()
print(s.maxFrequency([1, 2, 4], 5))
print(s.maxFrequency([1, 4, 8, 13], 5))
print(s.maxFrequency([3, 9, 6], 2))
