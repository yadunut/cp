# 224. Basic Calculator
OPERATORS = "+-"
class Solution:
    def calculate(self, s: str) -> int:
        result = 0
        currNum = 0
        sign = 1
        stack = []
        for c in s:
            if c == " ":
                continue
            if "0" <= c <= "9":
                currNum = currNum * 10 + int(c)
            elif c in OPERATORS:
                result += sign * currNum
                currNum = 0
                if c == "-":
                    sign = -1
                else:
                    sign = 1
            elif c == "(":
                stack.append((result, sign))
                result = 0
                sign = 1
            elif c == ")":
                result += sign * currNum
                r, s = stack.pop()
                result = result * s
                result += r
                currNum = 0

        return result + sign * currNum


s = Solution()
print(s.calculate("1 + 1"))
