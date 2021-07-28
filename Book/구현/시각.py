## 구현 - 완전탐색
# 시각

# 완전탐색은 데이터가 100만 개 이하일 때 사용이 적절하다.

n = 5 # 입력 예시, 시간
count = 0

for i in range(n + 1): # 시
    for j in range(60): # 분
        for k in range(60): # 초
            if '3' in str(i) + str(j) + str(k):
                count += 1

print(count)

