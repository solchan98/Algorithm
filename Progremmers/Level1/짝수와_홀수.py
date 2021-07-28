## 짝수와 홀수
# 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12937
# 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

ex1 = 3 # 입력 예시1, 기대 출력 : Odd
ex2 = 4 # 입력 예시2, 기대 출력 : Even

num = ex2
n_type = ""

n_type = num % 2 and "Odd" or "Even"
print(n_type)


