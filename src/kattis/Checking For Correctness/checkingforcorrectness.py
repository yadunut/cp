import sys

for line in sys.stdin:
    a, op, b = line.split()
    a = int(a)
    b = int(b)
    if op == "+":
        print((a + b) % 10000)
    if op == "*":
        print((a * b) % 10000)
    if op == "^":
        print(pow(a, b, 10000))
