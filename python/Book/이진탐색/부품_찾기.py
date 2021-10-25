# 부품 찾기, 난이도 중하

## Data
from sys import stdin

n = int(stdin.readline()) # 부품 수
array = sorted(list(map(int,stdin.readline().split()))) # 각 부품 번호
m = int(stdin.readline()) # 고객이 요청한 부품 수
x = list(map(int, stdin.readline().split())) # 고객이 요청한 부품 번호


def binarySearch(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None


for i in x:
    result = binarySearch(array, i, 0, n - 1)
    if result != None:
        print('yes')
    else:
        print('no')

## 풀이
# 1. 데이터 입력 받기
# 2. 가게 부품 번호 배열 정렬하기
# 3. 고객이 찾는 부품 번호 만큼 다음을 반복,
# 4. 각 번호 이잔탐색 수행#