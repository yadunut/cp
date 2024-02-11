# 1496. Path Crossing
class Solution:
    def isPathCrossing(self, path: str) -> bool:
        visited = set()
        visited.add((0, 0))
        curr = [0, 0]
        for p in path:
            if p == 'N':
                curr[0] += 1
            elif p == 'S':
                curr[0] -= 1
            elif p == 'E':
                curr[1] += 1
            elif p == 'W':
                curr[1] -= 1
            s = tuple(curr)
            if s in visited:
                return True
            visited.add(s)
        return False

s = Solution()
print(s.isPathCrossing( path = "NES"))
print(s.isPathCrossing(path = "NESWW"))
