from typing import List


class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        arr = sorted(arr)
        print(arr)
        if arr[0] != 1:
            arr[0] = 1
        for i in range(1, len(arr)):
            if abs(arr[i] - arr[i - 1]) <= 1:
                continue
            arr[i] = arr[i - 1] + 1
        return arr[-1]


s = Solution()
print(s.maximumElementAfterDecrementingAndRearranging([2, 2, 1, 2, 1]))
print(s.maximumElementAfterDecrementingAndRearranging([100, 1, 1000]))
print(s.maximumElementAfterDecrementingAndRearranging([1, 2, 3, 4, 5]))
