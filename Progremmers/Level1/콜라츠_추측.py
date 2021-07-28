## 콜라츠 추측
# 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12943

# 1-1. 입력된 수가 짝수라면 2로 나눕니다. 
# 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
# 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.

ex1 = 6 # 입력 예시1, 기대 출력 : 8
ex2 = 16 # 입력 예시2, 기대 출력 : 4
ex3 = 626331 # 입력 예시3, 기대 출력 : -1

num = ex1
count = 0

 # 짝수인 경우의 메서드
def evenFunc(num):
    num = num // 2
    return num

 # 홀수인 경우의 메서드
def oddFunc(num):
    num = num * 3 + 1
    return num

while num != 1:
    if num % 2 == 1: # Case: Odd
        num = oddFunc(num)
        count += 1
    elif count == 500:
        break
    else:
        num = evenFunc(num)
        count += 1

if count == 500:
    print(-1)
else:
    print(count)


