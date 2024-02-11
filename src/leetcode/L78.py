from typing import List


# 78. Subsets
class Solution:
    def subsets(self, n: List[int]) -> List[List[int]]:
        result = [[]]

        idx = 0
        for num in n:
            tmp = list(result)
            for i in tmp:
                result.append(i + [num])
            idx +=1
        return result

s = Solution()
print(s.subsets([1,2,3]))

            
