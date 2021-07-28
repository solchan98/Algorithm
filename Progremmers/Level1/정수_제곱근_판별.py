## 정수 제곱근 판별
# 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12934

ex1 = 121 # 입력 예시1, 기대 출력 : 144
ex2 = 3 # 입력 예시2, 기대 출력 : -1

def solution(n):
    sqrt = pow(n, 0.5);
    return pow(sqrt + 1, 2) if sqrt == int(sqrt) else -1

print(solution(ex1));
print(solution(ex2));