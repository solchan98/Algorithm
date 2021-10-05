# 타겟 넘버, Level2
from collections import deque

## DFS
def dfs(current, index, numbers, target):
    cnt = 0
    if index >= len(numbers):
        if current == target:
            return 1
        else:
            return 0
    cur1 = current + numbers[index]
    cur2 = current - numbers[index]
    
    cnt += dfs(cur1, index + 1, numbers, target)
    cnt += dfs(cur2, index + 1, numbers, target)

    return cnt
    
## BFS
def bfs(current, index, numbers, target):
    cnt = 0
    queue = deque()
    queue.append([current, index])
    while queue:
        cur, idx = queue.popleft()
        if idx < len(numbers):
            queue.append([cur + numbers[idx], idx + 1])
            queue.append([cur - numbers[idx], idx + 1])
        else:
            if cur == target:
                cnt += 1
    return cnt


def solution(numbers, target):
    cur = numbers[0]
    result = 0
    result += bfs(cur, 1, numbers, target)
    result += bfs(-cur, 1, numbers, target)
    return result

## 풀이(DFS)
# 공통. 초기 cur, index와 target 설정하여 + - 두 경우로 함수를 호출한다.
# 1. index가 5 이상인지 판단 / 함수가 5번 호출되었으면 종료
# 2. current값을 +1, -1 두 경우로 계산하여 재귀호출
## BFS
# 1. 큐 생성 후 첫 current값과 index값 넣기.
# 2. queue가 존재하는 동안 다음 작업 반복
# 3. queue에서 cur과 해당 cur의 index를 꺼내어 index가 5 미만인 경우 +1, -1 로직 실행
# 4. indexrk 5 이상인 경우 cur값과 target 값을 비교하여 cnt 증가