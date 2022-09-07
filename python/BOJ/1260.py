# DFS와 BFS
from collections import deque

## DFS
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

## BFS
def bfs(graph, v, visited):
    queue = deque([v])
    visited[v] = True
    while queue:
        qV = queue.popleft()
        print(qV, end=' ')
        for i in graph[qV]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


## Graph 생성
N, M, V = map(int, input().split())
graph = [[] for _ in range(N+1)]
graph[0] = [0, 0]

for i in range(M):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)
    graph[start].sort()
    graph[end].sort()

## 방문 체크 초기화 및 각각 호출
visited = [False] * (N + 1)
dfs(graph, V, visited)
print()
visited = [False] * (N + 1)
bfs(graph, V, visited)