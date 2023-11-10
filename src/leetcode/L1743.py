from collections import defaultdict
from typing import List
from typing_extensions import DefaultDict

class Solution:
	def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
		map = defaultdict(list)
		for pair in adjacentPairs:
			map[pair[0]].append(pair[1])
			map[pair[1]].append(pair[0])
		length  =  (len(adjacentPairs)+1)
		result = [0] * length
		for k, v in map.items():
			if len(v) == 1:
				result[0] = k
				result[1] = v[0]
				break
		for i in range(2, length):
			m = map[result[i-1]]
			if len(m) == 1:
				result[i] = m[0]
			else:
				result[i] = m[1] if m[0] == result[i-2] else m[0]
		return result


s = Solution()
print(s.restoreArray([[2,1],[3,4],[3,2]]))
print(s.restoreArray([[4,-2],[1,4],[-3,1]]))
