from typing import List

class Solution:
	def search(self, nums: List[int], target: int) -> int:
		left,right,mid= nums[0], nums[1], nums[len(nums)//2]
		if (target > left and target < right):
			pass

s = Solution()

print(s.search([4,5,6,7,0,1,2], 0))
print(s.search([4,5,6,7,0,1,2], 3))
