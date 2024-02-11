from typing import List
import math

dirs = [
    (-1, -1),
    (-1, 0),
    (-1, 1),
    (0, -1),
    (0, 0),
    (0, 1),
    (1, -1),
    (1, 0),
    (1, 1),
]


class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        ROWS = len(img)
        COLS = len(img[0])
        result = [[0 for _ in range(COLS)] for _ in range(ROWS)]
        for row in range(ROWS):
            for col in range(COLS):
                to_sum = [
                    img[row + r][col + c]
                    # (row+r, col+c)
                    for (r, c) in dirs
                    if 0 <= (row + r) < ROWS and 0 <= (col + c) < COLS
                ]
                print(row, col, to_sum)
                result[row][col] = sum(to_sum)//len(to_sum)
        return result

s = Solution()
# print(s.imageSmoother([[1, 1, 1], [1, 0, 1], [1, 1, 1]]))
print(s.imageSmoother(img = [[100,200,100],[200,50,200],[100,200,100]]))
