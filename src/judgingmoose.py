a,b = map(int, input().split())

if (a == 0 and b == 0):
	print('Not a moose')
else:
	print('Even' if a == b else 'Odd', max(a,b)*2)
