from typing import List, Tuple
from heapq import heapify, heappush, heappop
INF = int(9e9)
# 2642. Design Graph With Shortest Path Calculator
# Implement standard dijkstra's algorithm
class Graph:
	def __init__(self, n: int, edges: List[List[int]]):
		self.AL: List[List[Tuple[int, int]]] = [[] for _ in range(n)]
		for edge in edges:
			self.AL[edge[0]].append((edge[1], edge[2]))

	def addEdge(self, edge: List[int]) -> None:
		self.AL[edge[0]].append((edge[1], edge[2]))

	def shortestPath(self, node1: int, node2: int) -> int:
		dist = [INF for _ in self.AL]
		dist[node1] = 0
		pq = [(d[1], d[0]) for d in enumerate(dist)]
		heapify(pq)
		while pq:
			d, u = heappop(pq)
			for v, w in self.AL[u]:
				if dist[u]+w >= dist[v]: continue
				dist[v] = dist[u]+w
				heappush(pq, (dist[v], v))
		return dist[node2] if dist[node2] != INF else -1



# Your Graph object will be instantiated and called as such:
# obj = Graph(n, edges)
# obj.addEdge(edge)
# param_2 = obj.shortestPath(node1,node2)

g = Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]])
print(g.shortestPath(3, 2))
