## 그리디
# 거스름돈 최소 동전 개수 구하기

n = 1260 # 거스름 잔액
count = 0 # 거스름 동전 개수

coins = [500, 100, 50, 10] # 동전 종류

for coin in coins:
    count += n // coin
    n %= coin

print(count)