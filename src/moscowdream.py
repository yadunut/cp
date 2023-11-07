
[a, b, c, n] = [int(num) for num in input().split()]
if a == 0 or b == 0 or c == 0 or n < 3:
	print("NO")
	exit()
if a + b + c < n:
	print("NO")
	exit()
print("YES")
