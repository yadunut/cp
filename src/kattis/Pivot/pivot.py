n = input()
nums = [int(a) for a in input().split()]

res = set()
res.add(nums[0])
biggest = nums[0]
for num in nums:
    if num > biggest:
        res.add(num)
    biggest = max(biggest, num)
smallest = nums[-1]
for num in reversed(nums):
    if num > smallest and num in res:
        res.remove(num)
    smallest = min(smallest, num)
print(len(res))
