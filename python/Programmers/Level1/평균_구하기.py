## 평균 구하기
# 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12944

ex1 = [1, 2, 3, 4] # 입력 예시1, 기대 출력 : 2.5
ex2 = [5, 5] # 입력 예시2, 기대 출력 : 5

arr = ex2 # 입력 예시 설정
sum = 0

for num in arr:
    sum += num
result = sum / len(arr)
print(result)