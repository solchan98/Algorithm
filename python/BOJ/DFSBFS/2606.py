# 바이러스
from collections import deque

## node, edge 입력받기
node = int(input())
edge = int(input())

## 방문 확인
visited = [False] * (node + 1)

## 2차원 리스트의 그래프 입력받기
graph = [[] for _ in range(node+1)]
graph[0] = [0, 0]

for i in range(edge):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)
    graph[start].sort()
    graph[end].sort()

## BFS
def bfs(graph, v, visited):
    queue = deque([v])
    visited[v] = True
    while queue:
        qV = queue.popleft()
        for i in graph[qV]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
    print(visited.count(True) - 1)
bfs(graph, 1, visited)