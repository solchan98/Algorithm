# 미로 탈출
# 난이도 중하
# BFS

from collections import deque

n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 이동할 네 방향 정의
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

#BFS 
def bfs(x, y):
    # Queue 생성
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        # 네 방향 모두 탐색
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 범위 조건 검증
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            # 괴물이 존재하는 곳 - 무시
            if graph[nx][ny] == 0:
                continue
            # 처음 방문하는 곳 - 최단 거리 기록
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny)) # 큐에 추가
    # 가장 오른쪽 아래까지의 최단 거리 반환
    return graph[n - 1][m - 1]

print(bfs(0, 0))