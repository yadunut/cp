from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []

        def dfs(curr=[], options: List[int] = []):
            if len(options) == 0:
                result.append(curr)
                return
            for op in options:
                o = options.copy()
                o.remove(op)
                dfs(curr + [op], o)

        dfs([], nums)
        return result


s = Solution()
print(s.permute([1, 2, 3]))
