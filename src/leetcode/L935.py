class Solution:
    def knightDialer(self, n: int) -> int:
        cache = {
            i: 1 for i in range(10)
        }  # keeps track of number of moves from the current number
        print(cache)
        moves = {
            1: [6, 8],
            2: [7, 9],
            3: [4, 8],
            4: [3, 9, 0],
            5: [],
            6: [1, 7, 0],
            7: [2, 6],
            8: [1, 3],
            9: [2, 4],
            0: [4, 6],
        }


s = Solution()
print(s.knightDialer(1))
