# 프린터, Level2

def solution(priorities, location):
    index = []
    for i in range(len(priorities)):
        index.append(i)
    result = []
    while len(priorities) != 0:
        if priorities[0] == max(priorities):
            result.append(index.pop(0))
            priorities.pop(0)
        else:
            priorities.append(priorities.pop(0))
            index.append(index.pop(0))
    return result.index(location) + 1
    
# 풀이
# 1. 각 원소의 인덱스 순서를 갖는 index배열 생성
# 2. priorities가 존재하는 경우 반복
# 3. priorities의 0번째 값이 max값이면 prioriteis와 index에서 0번째 값 pop
# 4. pop한 값을 result에 append
# 5. 0번째 값이 max값이 아니면 pop하여 다시 append