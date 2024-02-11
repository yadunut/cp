from typing import List


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        ints = {int(x, base=2) for x in nums}
        for x in range(2 ** len(nums[0])):
            if x not in ints:
                return format(x, "0" + str(len(nums)) + "b")
        return ""


s = Solution()
print(s.findDifferentBinaryString(["01", "10"]))
print(s.findDifferentBinaryString(["00", "01"]))
print(s.findDifferentBinaryString(["111", "011", "001"]))
