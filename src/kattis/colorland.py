from collections import defaultdict, deque

n = int(input())

AL = defaultdict(list)
colors = [input() for i in range(n)]
s = set()
curr = None
for i, color in enumerate(colors):
    # first element just add
    if curr == None:
        curr = i
        continue
    if color not in s:
        AL[curr].append((i, color))
        s.add(color)
    else:
        # found the same value again. Find the same color node in the current AL
        newTup = AL[curr][-1]
        curr = newTup[0]
        s = set()
        s.add(color)
        AL[curr].append((i, color))

depth = 0
target = n - 1
queue = deque()
for i in AL[0]:
    queue.append(i)
while queue:
    currSize = len(queue)
    for i in range(currSize):
        curr = queue.popleft()
        if curr[0] == target:
            break
        for a in AL[curr[0]]:
            queue.append(a)
    depth += 1
print(depth)
