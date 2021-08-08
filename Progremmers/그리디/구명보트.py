# 구명보트, Level2

def solution(people, limit):
    answer = 0
    people.sort()
    i = 0
    j = len(people) - 1
    while i <= j:
        answer += 1
        if people[j] + people[i] <= limit:
            i += 1
        j -= 1
    return answer

# 풀이
# 1. people 오름차순으로 정렬
# 2. 가장 무거운 사람과 가장 가벼운 사람 두 명 가능한 경우, 
# 3. 가장 무거운 사람만 가능한 경우,
# 4. 2, 3 중 한 가지 경우에 속하니 조건을 통해 반복
# 5. 가장 가벼운 사람이 배에 타면 i + 1, 가장 무거운 사람이 배에 타면 j - 1#