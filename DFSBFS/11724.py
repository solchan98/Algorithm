# 연결 요소의 개수, Silver2

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
visited = [False] * (N + 1)
graph[0] = [0, 0]
result = 0

for _ in range(M):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)
    graph[start].sort()
    graph[end].sort()

def dfs(graph, start, visited):
    visited[start] = True
    for i in graph[start]:
        if not visited[i]:
            dfs(graph, i, visited)

for i in range(1, len(visited)):
    if visited[i] == False:
        result += 1
        dfs(graph, i, visited)

print(result)