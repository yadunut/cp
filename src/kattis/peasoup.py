numRes = int(input())

for i in range(numRes):
    numItems = int(input())
    name = input()
    items = [input() for i in range(numItems)]
    if "pancakes" in items and "pea soup" in items:
        print(name)
        exit()
print("Anywhere is fine I guess")
