# 공유기 설치, Silver1
import sys
input = sys.stdin.readline

## Insert Data
n, c = map(int, input().split())
array = []
for i in range(n):
    array.append(int(input()))
array.sort()

## Router Count
def findRouter(array, start, end):
    while start <= end:
        mid = (start + end) // 2
        current = array[0]
        count = 1

        for i in range(1, len(array)):
            if array[i] >= current + mid:
                count += 1
                current = array[i]

        if count >= c:
            global answer
            start = mid + 1
            answer = mid
        else:
            end = mid - 1


start = 1
end = array[-1] - array[0]
answer = 0
findRouter(array, start, end)
print(answer)

# 풀이
# 반복적으로 갭을 설정하여 C개 이상의 공유기를 설치하는 경우를 찾는다.
# 설치 가능한 공유기 개수가 C개 미만이면 갭을 감소시킨다.
# 설치 가능한 공유기 개수가 C개 이상이먄 갭을 증가시킨다.
# 반복이 끝나면 최종적인 갭을 반환한다.##

# 어렵네.. #