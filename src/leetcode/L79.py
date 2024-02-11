from collections import defaultdict
from typing import Dict, List, Tuple

DIRS = [(1, 0), (-1, 0), (0, 1), (0, -1)]

# 79. Word Search
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(idx, pos, visited):
            # print(idx, pos, visited)
            if idx == len(word):
                return True
            if pos[0] < 0 or pos[0] >= len(board):
                return False
            if pos[1] < 0 or pos[1] >= len(board[0]):
                return False
            if board[pos[0]][pos[1]] != word[idx]:
                return False
            if pos in visited:
                return False
            visited.add(pos)
            for dir in DIRS:
                if dfs(idx + 1, (pos[0] + dir[0], pos[1] + dir[1]), visited):
                    return True
            visited.remove(pos)

        for row in range(len(board)):
            for col in range(len(board[row])):
                if dfs(0, (row, col), set()):
                    return True
        return False


s = Solution()
# print(
#     s.exist(
#         board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]],
#         word="ABCB",
#     )
# )
# print(
#     s.exist(
#         board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]],
#         word="SEE",
#     )
# )
print(
    s.exist(
        board=[["A", "B", "C", "E"], ["S", "F", "E", "S"], ["A", "D", "E", "E"]],
        word="ABCESEEEFS",
    )
)
