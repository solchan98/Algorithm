# 수 찾기, Silver4
from sys import stdin

## Data
N = int(stdin.readline())
A = sorted(map(int,stdin.readline().split()))
M = int(stdin.readline())
B = map(int, stdin.readline().split())

def isInNumber(i, A, start, end):
    if start > end: # start는 계속 +1, end는 계속 -1
        return 0;
    m = (start + end) // 2;
    if i == A[m]:
        return 1;
    if i > A[m]:
        return isInNumber(i, A, m+1, end);
    else:
        return isInNumber(i, A, start, m-1);

for i in B:
    start = 0;
    end = N - 1;
    print(isInNumber(i, A, start, end));

# 풀이
# 1. Data 받기
# 2. 탐색 대상의 중간을 찾아 비교
# 3. 같으면 응답
# 4. 탐색 대상보다 작으면 중간 값 기준 end값 -1 하여 재귀 호출
# 5. 탐색 새당보다 크면 중간 값 기준 start +1 하여 재귀 호출