from typing import List


# 17. Letter Combinations of a Phone Number
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {
            "2": ["a", "b", "c"],
            "3": ["d", "e", "f"],
            "4": ["g", "h", "i"],
            "5": ["j", "k", "l"],
            "6": ["m", "n", "o"],
            "7": ["p", "q", "r", "s"],
            "8": ["t", "u", "v"],
            "9": ["w", "x", "y", "z"],
        }
        res = []

        def backtrack(i, currStr):
            if len(currStr) == len(digits):
                res.append(currStr)
                return
            letters = mapping[digits[i]]
            for l in letters:
                backtrack(i+1, currStr + l)

        backtrack(0, "")
        if len(res) == 1 and res[0] == "":
            return []
        return res


s = Solution()
print(s.letterCombinations("232"))
