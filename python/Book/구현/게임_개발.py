## 구현
# 게임 개발
# 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, 1]

mapX = 4
mapY = 4

manX = 1
manY = 1
manD = 0

# 캐릭터가 방문한 칸의 수
## 초기 시작 칸 방문 카운트, 회전 횟수
count = 1
turnCnt = 0

# 1 바다 or 방문전적, 0 육지
mapStatus = [[1, 1, 1, 1], [1, 0, 0, 1], [1, 1, 0, 1], [1, 1, 1, 1]]
# 방문 여부
mapVit = [[1, 1, 1, 1], [1, 0, 0, 1], [1, 1, 0, 1], [1, 1, 1, 1]]

# 처음 시작 칸 방문 여부 설정
mapStatus[manX][manY] = 1

# 왼쪽으로 회전
def turn_left():
    global manD
    manD -= 1
    if(manD == -1):
        manD = 3

while True:
    turn_left()
    # nx, ny는 캐릭터가 바라보는 방향의 앞 칸 좌표
    nx = manX + dx[manD]
    ny = manY + dx[manD]
    # 회전이후 바라보는 방향의 앞 칸이 처음 가보는 칸인 경우
    if mapVit[nx][ny] == 0:
        mapVit[nx][ny] = 1
        x = nx
        y = ny
        count += 1
        turnCnt += 1
        continue
    # 회전이후 바라보는 방향의 앞 칸이 바다이거나 방문했던 칸인 경우
    else:
        turnCnt += 1
    # 4방향 모두 갈 수 없는 경우
    if turnCnt == 4:
        nx = manX - dx[manD]
        ny = manY - dy[manD]
        # 캐릭터 반대 방향이 바다가 아닌 경우
        if mapStatus[nx][ny] == 0:
            manX = nx
            manY = ny
        # 바다인 경우
        else:
            break
        turnCnt = 0

print(count)


    