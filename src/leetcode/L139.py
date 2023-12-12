from typing import Dict, List, Tuple
from collections import defaultdict

# 139. Word Break

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        cache = [False] * (len(s) + 1)
        cache[len(s)] = True
        for i in range(len(s) - 1, -1, -1):
            for word in wordDict:
                if (i + len(word)) <= len(s) and s[i : i + len(word)] == word:
                    cache[i] = cache[i + len(word)]
                if cache[i]:
                    break
        print(cache)
        return cache[0]


s = Solution()
# print(s.wordBreak(s="leetcode", wordDict=["leet", "code"]))
# print(s.wordBreak(s = "applepenapple", wordDict = ["apple","pen"]))
# print(s.wordBreak(s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]))
print(s.wordBreak("cars", ["car", "ca", "rs"]))
