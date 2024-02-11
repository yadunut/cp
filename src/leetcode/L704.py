from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            print(l, r, mid)
            if nums[mid] == target:
                return mid
            if target > nums[mid]:
                l = mid + 1
            elif target < nums[mid]:
                r = mid - 1
        return -1

s = Solution()
print(s.search([5], 5))
