from typing import List

# 1921. Eliminate Maximum Number of Monsters


def eliminateMaximum(dist: List[int], speed: List[int]) -> int:
    res = sorted([a / b for a, b in zip(dist, speed)])
    print(res)
    counter = 0
    for i in res:
        if counter < i:
            counter = counter + 1
        else:
            return counter
    return len(dist)


print(eliminateMaximum([1, 3, 4], [1, 1, 1]))
print(eliminateMaximum([1, 1, 2, 3], [1, 1, 1, 1]))
print(eliminateMaximum([3, 2, 4], [5, 3, 2]))
