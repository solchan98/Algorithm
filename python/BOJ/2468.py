# 안전 영역, Silver1

from collections import deque

## 상 하 좌 우
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N = int(input())
sample = []
maxCnt = 0
result = 0

## sample 2차원 배열 입력받기
for i in range(N):
    a = list(map(int, input().split()))
    sample.append(a)

## bfs 수행 메서드
def bfs(i, j):
    queue = deque()
    queue.append([i,j]) # 위치 지정
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if  0 <= nx < N and 0 <= ny < N and graph[nx][ny] == 0:
                graph[nx][ny] = 1
                queue.append([nx, ny])

## 높이는 1이상 100 이하, 이 중 최대 안전 지역 찾기
for i in range(0 , 101):
    graph = [[0] * N for i in range(N)]
    cnt = 0
    for j in range(N):
        for k in range(N):
            if sample[j][k] <= i:
                graph[j][k] = 1
                
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 0:
                bfs(i, j)
                cnt += 1
    maxCnt = max(maxCnt, cnt)
print(maxCnt)