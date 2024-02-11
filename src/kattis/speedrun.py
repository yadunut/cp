G, N = [int(x) for x in input().split(" ")]
tasks = []
for _ in range(N):
    s, e = [int(x) for x in input().split(" ")]
    tasks.append((e, s))
tasks.sort()
print(tasks)

p = 0
count = 1
for i in range(1, N, 1):
    curr = tasks[i]
    prev = tasks[p]
    if curr[1] >= prev[0]:
        count += 1
        p = i
print("YES" if count >= G else "NO")
