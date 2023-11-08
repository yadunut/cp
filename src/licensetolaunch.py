input()

nums = enumerate(map(int, input().split()))
print(min(nums, key=lambda x:x[1])[0])
