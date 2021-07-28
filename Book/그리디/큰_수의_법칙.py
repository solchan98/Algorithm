## 그리디
# 가장 큰 수 구하기
m = 8 # 뎃셈 횟수
k = 3 # 1회 최대 덧셈 회수

n = [2, 4, 5, 4, 6] # 배열
n.sort()

f_count = m // (k + 1) * k
f_count += m % (k + 1)

total = n[-1] * f_count
total += n[-2] * (m - f_count)

print(total)