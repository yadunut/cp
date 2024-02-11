from typing import List


# 2391. Minimum Amount of Time to Collect Garbage
class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        numG = numP = numM = 0
        lastG = lastP = lastM = 0
        for i in range(len(garbage)):
            if "G" in garbage[i]:
                numG += garbage[i].count("G")
                lastG = i
            if "P" in garbage[i]:
                numP += garbage[i].count("P")
                lastP = i
            if "M" in garbage[i]:
                numM += garbage[i].count("M")
                lastM = i
        sum = [0] * len(travel)
        sum[0] = travel[0]
        for i in range(1, len(travel)):
            sum[i] = sum[i - 1] + travel[i]
        result = numG + numP + numM
        result += sum[lastG - 1] if numG > 0 and (lastG - 1) >= 0 else 0
        result += sum[lastP - 1] if numP > 0 and (lastP - 1) >= 0 else 0
        result += sum[lastM - 1] if numM > 0 and (lastM - 1) >= 0 else 0
        return result


s = Solution()
# print(s.garbageCollection(garbage = ["G","P","GP","GG"], travel = [2,4,3]))
# print(s.garbageCollection(["MMM","PGM","GP"], travel = [3,10]))
print(s.garbageCollection(["G", "M"], [1]))
