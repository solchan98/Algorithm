# 섬의 개수, Sliver2
from collections import deque

## 상 하 좌 우 우상 좌상 우하 좌하
dx = [0, 0, -1, 1, 1, -1, 1, -1]
dy = [-1, 1, 0, 0, -1, -1, 1, 1]

def bfs(i, j):
    queue = deque()
    queue.append([i, j])
    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < h and 0 <= ny < w and s[nx][ny] == 1:
                queue.append([nx, ny])
                s[nx][ny] = 0

while True:
    result = 0
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    s = []
    cnt = 0
    for i in range(h):
        s.append(list(map(int, input().split())))
    for i in range(h):
        for j in range(w):
            if s[i][j] == 1:
                bfs(i, j)
                result += 1
    print(result)