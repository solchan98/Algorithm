from collections import deque

n = int(input())
graph = [list(map(int, input())) for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def bfs(g, ix, iy):
    queue = deque()
    queue.append((ix, iy))
    g[i][j] = 0
    count = 1

    while queue:
        x, y = queue.popleft()
        for index in range(4):
            nx = x + dx[index]
            ny = y + dy[index]

            if nx < 0 or nx >= n or ny >= n or ny < 0:
                continue
            if g[nx][ny] == 1:
                g[nx][ny] = 0
                queue.append((nx, ny))
                count += 1
    return count


group_list = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            group_list.append(bfs(graph, i, j))

group_list.sort()
print(len(group_list))
for group in group_list:
    print(group)
