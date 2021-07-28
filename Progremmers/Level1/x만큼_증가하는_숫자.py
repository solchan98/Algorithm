## x만큼 간격이 있는 n개의 숫자
# 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12954

ex1 = {"x" : 2, "n": 5} # 입력 예시1 / 기대 출력 : [2, 4, 6, 8, 10]
ex2 = {"x" : 4, "n": 3} # 입력 예시2 / 기대 출력 : [4, 8, 12]
ex3 = {"x" : -4, "n": 2} # 입력 예시2 / 기대 출력 : [-4, -8]
answer = [] # 출력 결과

for i in range(1, ex3["n"] + 1):
    answer.append(ex3["x"] * i)

print(answer)