# Solving with UFDS
# step 1: for each email, add to a set and index them. This index will be the ID.
# Create a union find of the size of the set and then iterate through each list and merge them.
# Each "tree" in the union find will be the solution to the problem

# Create a map of email -> accounts
from typing import List
from collections import defaultdict


class UnionFind:
    def __init__(self, n: int) -> None:
        self.groups = n
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
        self.groups -= 1


class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        ufds = UnionFind(len(accounts))

        emails_to_accId: dict[str, int] = {}
        for accId, account in enumerate(accounts):
            for email in account[1:]:
                if email not in emails_to_accId:
                    emails_to_accId[email] = accId
                else:
                    ufds.unionSet(accId, emails_to_accId[email])

        result: dict[int, List[str]] = defaultdict(list)
        for email, accId in emails_to_accId.items():
            id = ufds.find(accId)
            result[id].append(email)
        for key in result:
            result[key].sort()
            result[key].insert(0, accounts[key][0])
        return list(result.values())


s = Solution()
print(
    s.accountsMerge(
        accounts=[
            ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
            ["John", "johnsmith@mail.com", "john00@mail.com"],
            ["Mary", "mary@mail.com"],
            ["John", "johnnybravo@mail.com"],
        ]
    )
)
