from typing import List
from collections import Counter

# 438. Find All Anagrams in a String
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        P = Counter(p)
        A = Counter(s[0 : len(p)])
        result = [0] if P == A else []

        l = 0
        for r in range(len(p), len(s)):
            A[s[r]] += 1
            A[s[l]] -= 1
            if not A[s[l]]:
                del A[s[l]]
            l += 1
            if A == P:
                result.append(l)

        return result


s = Solution()
print(s.findAnagrams(s="cbaebabacd", p="abc"))
print(s.findAnagrams(s="abab", p="ab"))
