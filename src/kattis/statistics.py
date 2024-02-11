import fileinput

for line in fileinput.input():
    nums = list(map(int, line.split()))[1:]
    print(
        "Case " + str(fileinput.filelineno()) + ":",
        min(nums),
        max(nums),
        max(nums) - min(nums),
    )
