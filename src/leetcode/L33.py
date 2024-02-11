from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid
            if nums[l] <= nums[mid]:  # we are in the left sorted portion
                if target > nums[mid] or target < nums[l]:  # we search right
                    l = mid + 1
                else:
                    r = mid - 1
            else:  # we are in the right sorted portion
                if target < nums[mid] or target > nums[r]:  # we search right
                    r = mid - 1
                else:
                    l = mid + 1
        return -1


s = Solution()

print(s.search([4, 5, 6, 7, 0, 1, 2], 0))
# print(s.search([4,5,6,7,0,1,2], 3))
