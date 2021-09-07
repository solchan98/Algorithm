# 공유기 설치, Silver1
from sys import stdin

## Insert Data
N, C = map(int, stdin.readline().split());
house = [];
for i in range(N):
    house.append(int(stdin.readline()));

house.sort();

## Router Count
def findRouter(start, end):
    answer = 0;
    while start <= end:
        mid = (start + end) // 2;
        current = house[0];
        count = 1;

        for i in range(1, len(house)):
            if house[i] >= current + mid:
                count += 1;
                current = house[i];

        if count >= C:
            start = mid + 1;
            answer = mid;
        else:
            end = mid - 1;
    return answer;


start = house[0];
end = house[-1] - house[0];

print(findRouter(start, end));


# 풀이
# 반복적으로 갭을 설정하여 C개 이상의 공유기를 설치하는 경우를 찾는다.
# 설치 가능한 공유기 개수가 C개 미만이면 갭을 감소시킨다.
# 설치 가능한 공유기 개수가 C개 이상이먄 갭을 증가시킨다.
# 반복이 끝나면 최종적인 갭을 반환한다.##

# 어렵네.. #