x = int(input())
acc = 0
for i in range(0, x):
	x, y = map(float, input().split())
	acc = acc + (x*y)
print(acc)
