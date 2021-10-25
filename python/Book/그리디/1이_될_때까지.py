## 그리디
# 1이 될 때까지
# 책 해설과 다른 풀이
n = 43 # 입력 예시, N값
k = 4 # 입력 예시, K값

count = 0 # 총 계산 횟수

while n != 1:
    if n % k:
        n -= 1
        count += 1
        continue
    n = n / k
    count += 1

print(count)