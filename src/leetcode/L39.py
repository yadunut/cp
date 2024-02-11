from typing import List, Set


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = set()

        def dfs(t: int, path=[]):
            # print(t, path, result)
            for c in candidates:
                if t - c == 0:
                    r = list(path)
                    r.append(c)
                    r.sort()
                    result.add(tuple(r))
                if t - c > 0:
                    dfs(t - c, path + [c])

        dfs(target)
        return list(result)


s = Solution()


class S2:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(i, cur: List[int], total):
            if total == target:
                res.append(cur.copy())
                return
            if i >= len(candidates) or total > target:
                return
            cur.append(candidates[i])
            dfs(i, cur, total + candidates[i])
            cur.pop()
            dfs(i + 1, cur, total)

        dfs(0, [], 0)
        return res


# print(s.combinationSum(candidates = [2,3,6,7], target = 7))
# print(s.combinationSum([8,7,4,3], 11))
print(s.combinationSum([2, 3, 6, 7], 7))
