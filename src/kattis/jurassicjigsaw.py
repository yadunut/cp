from collections import Counter

a = Counter("GAACAG")
b = Counter("AAAAAA")
print(a.most_common(1))
print(b.most_common(1))
print(a)
print(b)
print(a - b)
