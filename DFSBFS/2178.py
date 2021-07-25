# 미로 탈출
from collections import deque

## N, M 입력받기(공백으로 구분)
n, m = map(int, input().split())

## 2차원 리스트의 그래프 입력받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

## 이동 방향 4개 정의 (좌, 우, 상, 하)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y =  queue.popleft()
        # 좌 우 상 하 확인
        for i in range(4):
            # x, y 값 이동 위치 값으로 변경
            nx = x + dx[i]
            ny = y + dy[i]
            # 범위 밖 조건 처리
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            # 이동 불가 칸 처리
            if graph[nx][ny] == 0:
                continue
            # 처음 방문일 경우 거리 값 수정
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    return graph[n - 1][m - 1]

print(bfs(0, 0))
