# 76. Minimum Window Substring
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        if t == s:
            return t
        # Idea: keep a counter of s and t. have a left and right pointer. 
