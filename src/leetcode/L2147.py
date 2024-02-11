from collections import Counter


class Solution:
    def numberOfWays(self, corridor: str) -> int:
        seats = [i for i, s in enumerate(corridor) if s == "S"]
        if len(seats) % 2 == 1 or len(seats) == 0:
            return 0
        res = 1
        for i in range(2, len(seats), 2):
            res *= seats[i] - seats[i - 1]
        return res % (10**9 + 7)


s = Solution()
print(s.numberOfWays("SSPPSPS"))
print(s.numberOfWays("PPSPSP"))
print(s.numberOfWays("S"))
print(s.numberOfWays("P"))
