from typing import List


# 54. Spiral Matrix
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        width = len(matrix[0])
        height = len(matrix)
        numElems = width * height
        print(width, height, numElems)
        center = (height // 2, width // 2)
        print(center)
        currRow, currCol, dirRow, dirCol = 0, 0, 0, 1
        up, down, left, right = 1, height - 1, 0, width - 1
        result = []
        while len(result) < numElems-1:
            print(f'u: {up}, d: {down}, l: {left}, r: {right}, coord:({currRow}, {currCol})')
            result.append(matrix[currRow][currCol])
            if currCol == right and dirCol == 1:
                right -= 1
                dirCol = 0
                dirRow = 1
            elif currCol == left and dirCol == -1:
                left += 1
                dirCol = 0
                dirRow = -1
            if currRow == down and dirRow == 1:
                down -= 1
                dirRow = 0
                dirCol = -1
            elif currRow == up and dirRow == -1:
                up += 1
                dirRow = 0
                dirCol = 1

            currCol += dirCol
            currRow += dirRow

        result.append(matrix[currRow][currCol])
        return result


s = Solution()
print(s.spiralOrder(matrix=[[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
print(s.spiralOrder(matrix=[[6,9,7]]))
# print(s.spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]))
