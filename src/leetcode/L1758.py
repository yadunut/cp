# 1758. Minimum Changes To Make Alternating Binary String


class Solution:
    def minOperations(self, s: str) -> int:
        s1 = 1
        s0 = 0
        c1 = 0
        c0 = 0
        for d in s:
            c1 += 1 if ord(d) - ord("0") == s1 else 0
            c0 += 1 if ord(d) - ord("0") == s0 else 0
            s1 = 1 if s1 == 0 else 0
            s0 = 1 if s0 == 0 else 0
        return min(c1, c0)


s = Solution()
# print(s.minOperations(s = "1011"))
# print(s.minOperations(s = "10"))
# print(s.minOperations(s = "1111"))
print(s.minOperations(s="10010100"))
