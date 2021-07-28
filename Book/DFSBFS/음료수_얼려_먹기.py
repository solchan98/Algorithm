# 음료수 얼려 먹기
# 난이도 중하
# DFS

n, m = map(int, input().split())

graph =[]
for i in range(n):
    graph.append(list(map(int, input())))

# DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(x, y):
    # 범위 밖 조건 검증
    if x <= -1 or x >=n or y <= -1 or y >= m:
        return False
    print(x, y)
    # 방문하지 않은 노드인 경우
    if graph[x][y] ==0:
        graph[x][y] = 1 # 방문 처리
        # 상하좌우 모두 재귀적으로 호출
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

# 모든 노드에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)