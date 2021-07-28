# 유기농 배추, Siver2
import sys
sys.setrecursionlimit(10000) ## RecursionError 방지

cnt = int(input()) # 테스트 횟수

def dfs(x, y):
    if x <= -1 or x >= N or y <= -1 or y >= M:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        ## 상하좌우를 모두 방문하여 방문처리 -> 상하좌우로 연결된 모든 배추를 한 번에 묶음으로 처리하여
        ## 묶음 카운트 1개 증가
        dfs(x + 1, y)
        dfs(x - 1, y)
        dfs(x, y + 1)
        dfs(x, y - 1)
        return True # graph[x][y]가 1인 경우
    return False # 1이 아닌경우 

for i in range(cnt) :
    ## N = 가로, M = 세로, V = 배추
    N, M, V = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    ## 배추 위치 1로 변경
    for i in range(V):
        a, b = map(int, input().split())
        graph[a][b] = 1
    ## 탐색
    result = 0
    for i in range(N):
        for j in range(M):
            if dfs(i, j) == True:
                result += 1
    print(result)