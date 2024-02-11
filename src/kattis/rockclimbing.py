# Question from CS2040C-22-23S1 Finals


H = 290000
U = 70
n = [(130, 150), (152, 220)]

DP = [(float("inf"), -1)] * (H + U)  # (numMoves, from)
for r in n:
    for i in range(r[0], r[1]):
        DP[i] = (-1, -1)
DP[0] = (0, 0)
count = 0
for i in range(0, H + 1):
    if DP[i][0] == -1:
        continue
    if i + U < H + U:
        DP[i + U] = min(DP[i + U], (DP[i][0] + 1, i))
        for a in range(i, i + U):
            DP[a] = min(DP[a], (DP[i][0] + 2, i))
            count += 1
print(count)
# print(DP[H])
curr = DP[H]
# while curr[1] != 0:
#     print(curr)
#     curr = DP[curr[1]]
print(curr)
