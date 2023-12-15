class UnionFind:
    def __init__(self, n: int) -> None:
        self.parents = [i for i in range(n)]
        self.rank = [0] * n

    def find(self, x: int):  # does compression! all the way until root
        if self.parents[x] != x:
            self.parents[x] = self.find(self.parents[x])
        return self.parents[x]

    def isSameSet(self, a: int, b: int):
        return self.find(a) == self.find(b)

    def unionSet(self, a: int, b: int):
        x = self.find(a)
        y = self.find(b)
        if x == y:
            return
        if self.rank[x] < self.rank[y]:
            self.parents[x] = y
        elif self.rank[x] > self.rank[y]:
            self.parents[y] = x
        else:
            self.parents[y] = x
            self.rank[x] += 1
