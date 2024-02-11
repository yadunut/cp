import math

n = int(input())
teas = list(map(int, input().split()))
input()
toppings = list(map(int, input().split()))

values = []

minV = math.inf
for i in range(0, n):
    combos = [toppings[int(a) - 1] + teas[i] for a in input().split()][1:]
    values = values + combos
    # print(combos)

money = int(input())
minV = min(values)
print(max(money // minV - 1, 0))
