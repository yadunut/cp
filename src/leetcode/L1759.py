class Solution:
	def countHomogenous(self, s: str) -> int:
		count = 0
		curr = ''
		currCount = 0
		for c in s:
			if curr == c:
				currCount = currCount+1
			else:
				currCount = 1
				curr = c
			count = count + currCount

		return count % (10**9 + 7)

s = Solution()
print(s.countHomogenous('abbcccaa'))
print(s.countHomogenous('xy'))
print(s.countHomogenous('zzzzz'))
