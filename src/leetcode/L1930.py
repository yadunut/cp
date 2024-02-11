# 	1930. Unique Length-3 Palindromic Subsequences
# 3 letter palindrome would be x?x.
import string


class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        result = 0
        for c in string.ascii_lowercase:
            firstC = s.find(c)
            lastC = s.rfind(c)
            if firstC == lastC or firstC == -1:
                continue
            result += len(set(s[firstC + 1 : lastC]))
        return result


s = Solution()
print(s.countPalindromicSubsequence("aabca"))
print(s.countPalindromicSubsequence("adc"))
print(s.countPalindromicSubsequence("bbcbaba"))
