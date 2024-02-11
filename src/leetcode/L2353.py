from dataclasses import dataclass
from collections import defaultdict
from typing import List
from heapq import heapify, heappush, heappop


# 2353. Design a Food Rating System
@dataclass(order=True)
class Entry:
    rating: int
    food: str
    cusine: str


class FoodRatings:
    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.cusinesMap: dict[str, List[Entry]] = defaultdict(list)
        self.foodMap: dict[str, Entry] = {}
        for f, c, r in zip(foods, cuisines, ratings):
            e = Entry(-r, f, c)
            heappush(self.cusinesMap[c], e)
            self.foodMap[f] = e

    def changeRating(self, food: str, newRating: int) -> None:
        oldE = self.foodMap[food]
        oldE.food = "REMOVED"
        c = oldE.cusine
        newE = Entry(-newRating, food, c)
        self.foodMap[food] = newE
        heappush(self.cusinesMap[c], newE)

    def highestRated(self, cuisine: str) -> str:
        while self.cusinesMap[cuisine][0].food == "REMOVED":
            heappop(self.cusinesMap[cuisine])
        return self.cusinesMap[cuisine][0].food
