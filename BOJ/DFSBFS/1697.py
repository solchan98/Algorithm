# 숨바꼭질, Silver1
from collections import deque

def bfs(n, m):
    queue = deque()
    queue.append(n) # 출발 위치 설정
    while queue:
        x = queue.popleft()
        if x == m:
            print(dist[x])
            break
        for nx in (x - 1, x + 1, x * 2):
            if nx < 0 or nx > MAX or dist[nx]:
                continue
            dist[nx] = dist[x] + 1
            queue.append(nx)

N, M = map(int, input().split())
MAX = 100000
dist = [0] * (MAX + 1)
bfs(N, M)