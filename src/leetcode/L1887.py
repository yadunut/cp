from typing import List

# 1887. Reduction Operations to Make the Array Elements Equal
LEN = 5 * 10**4


class Solution:
    def reductionOperations(self, nums: List[int]) -> int:
        counter = [0] * (LEN + 1)
        minNum = min(nums)
        for num in nums:
            counter[num] += 1
        sum = 0
        c = 0
        for i in range(LEN, 0, -1):
            if counter[i] == 0:
                continue
            if i == minNum:
                break
            sum += c + counter[i]
            c += counter[i]
        return sum


s = Solution()
print(s.reductionOperations([5, 1, 3]))
print(s.reductionOperations([1, 1, 1]))
print(s.reductionOperations([1, 1, 2, 2, 3]))
print(s.reductionOperations([7, 9, 10, 8, 6, 4, 1, 5, 2, 3]))
