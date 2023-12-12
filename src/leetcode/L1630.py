from typing import List

# 1630. Arithmetic Subarrays


class Solution:
    def checkArithmeticSubarrays(
        self, nums: List[int], l: List[int], r: List[int]
    ) -> List[bool]:
        result = []
        for i in range(len(l)):
            srted = sorted(nums[l[i] : r[i] + 1])
            # print(srted)
            result.append(
                len(set([srted[x + 1] - srted[x] for x in range(len(srted) - 1)])) == 1
            )
        return result


s = Solution()
print(s.checkArithmeticSubarrays(nums=[4, 6, 5, 9, 3, 7], l=[0, 0, 2], r=[2, 3, 5]))
print(
    s.checkArithmeticSubarrays(
        nums=[-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10],
        l=[0, 1, 6, 4, 8, 7],
        r=[4, 4, 9, 7, 9, 10],
    )
)
