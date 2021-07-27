# 토마토, Silver1
from collections import deque
m, n = map(int, input().split())
s = []
queue = deque()
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(n):
    s.append(list(map(int, input().split())))

## 익은 토마토 위치 넣기
for i in range(n):
    for j in range(m):
        if s[i][j] == 1:
            queue.append([i, j])

def bfs():
    while queue:
        a, b = queue.popleft()
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0 <= x < n and 0 <= y < m and s[x][y] == 0:
                s[x][y] = s[a][b] + 1
                queue.append([x, y])

bfs()
checkTomato = False
result = -999
for i in s:
    for j in i:
        if j == 0:
            checkTomato = True
        result = max(result, j)

if checkTomato == True:
    print(-1)
elif result == -1:
    print(0)
else:
    print(result - 1)