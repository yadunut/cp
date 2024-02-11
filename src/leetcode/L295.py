from heapq import heappush, heappop


# 295. Find Median from Data Stream
class MedianFinder:
    def __init__(self):
        self.left = []  # maxheap, Values are negative.
        self.right = []  # minheap
        pass

    def addNum(self, num: int) -> None:
        if not self.left:
            heappush(self.left, -num)
        elif num <= -self.left[0]:
            heappush(self.left, -num)
        else:
            heappush(self.right, num)
        self.balance()

        # the first 2 elements will always go left and right
        # if num <

    def findMedian(self) -> float:
        # if is odd, then return the element from the longer list
        # print('l', self.left)
        # print('r', self.right)
        lLen = len(self.left)
        rLen = len(self.right)
        if (lLen + rLen) % 2 == 1:
            if lLen > rLen:
                return -self.left[0]
            else:
                return self.right[0]
        else:
            # assume its balanced
            return (-self.left[0] + self.right[0]) / 2

    def balance(self):
        if len(self.left) > len(self.right) + 1:
            l = -heappop(self.left)
            heappush(self.right, l)
        elif len(self.right) > len(self.left) + 1:
            r = heappop(self.right)
            heappush(self.left, -r)


s = MedianFinder()
s.addNum(1)
print(s.findMedian())
s.addNum(2)
print(s.findMedian())
s.addNum(3)
print(s.findMedian())
s.addNum(4)
print(s.findMedian())
s.addNum(5)
print(s.findMedian())
s.addNum(6)
print(s.findMedian())
s.addNum(7)
print(s.findMedian())
s.addNum(8)
print(s.findMedian())
s.addNum(9)
print(s.findMedian())
s.addNum(10)
print(s.findMedian())
