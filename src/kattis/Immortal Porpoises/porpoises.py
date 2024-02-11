n = int(input())


def fib(n):
    a, b = 0, 1
    for _ in range(n):
        a, b = b, a + b
    return a

print(fib(10))

# for _ in range(n):
#     ds, year = [int(i) for i in input().split()]
#     print(fib(year))
