from collections import defaultdict
from heapq import heapify, heappop, heappush

nIslands, nBridges = [int(i) for i in input().split()]
AL = defaultdict(list)

for i in range(nBridges):
    i1, i2 = [int(i) for i in input().split()]
    AL[i1].append(i2)
    AL[i2].append(i1)
# print(AL)

weights = dict()

for i in range(1, nIslands + 1):
    weights[i] = int(input())
# print(weights)

armySize = weights[1]
pQueue = [(weights[a], a) for a in AL[1]]
heapify(pQueue)
visited = set()
visited.add(1)
# print(pQueue)

while pQueue:
    w, curr = heappop(pQueue)
    # print((w, curr))
    if w >= armySize:
        break
    if curr in visited:
        continue
    # print('adding', w, 'to', armySize)
    armySize += w
    visited.add(curr)
    for a in AL[curr]:
        heappush(pQueue, (weights[a], a))
print(armySize)
