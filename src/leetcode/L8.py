class Solution:
    def myAtoi(self, s: str) -> int:
        res_s = ""
        neg = None
        for c in s:
            if c == " " and res_s == "" and neg == None:
                continue
            elif neg == None and res_s == "" and c == "-":
                neg = True
                continue
            elif neg == None and res_s == "" and c == "+":
                neg = False
            elif c < "0" or c > "9":
                break
            else:
                res_s += c
        res = 0
        for i, c in enumerate(reversed(res_s)):
            res += (ord(c) - ord("0")) * (10 ** i)

        if neg:
            res = -res
            return max(res, -(2 ** 31))
        return min(res, (2**31)-1)

s = Solution()
