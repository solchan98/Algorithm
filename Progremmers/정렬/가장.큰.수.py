# 가장 큰 수, Level2

def solution(numbers):
    num = list(map(str, numbers))
    num.sort(key=lambda x : x*3, reverse=True)
    return str(int(''.join(num)))

result = solution([0, 0, 0, 0])
print(result, type(result))

#풀이
# 1. numbers를 각각 문자로 바꾸어 list로 만든다.
# 2. lamda와 reverse를 통해 각 문자값을 3번 곱하여 정렬한다.
# 3. 각 문자값을 join한 결과를 int로 한 번 변환 후 str로 다시 변환한다.
# 3번의 이유는 [0, 0, 0 0]의 경우 0이 아닌 0000이 리턴되기 때문이다. #