from typing import List


# 75. Sort Colors
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        i, l, r = 0, 0, len(nums) - 1
        while i <= r:
            if nums[i] == 0:
                print("swapping", i, "with", l)
                nums[i], nums[l] = nums[l], nums[i]
                l += 1
                i += 1
            elif nums[i] == 2:
                print("swapping", i, "with", r)
                nums[i], nums[r] = nums[r], nums[i]
                r -= 1
            else:
                i += 1

s = Solution()
nums = [2,0,1]
s.sortColors(nums)
print(nums)
