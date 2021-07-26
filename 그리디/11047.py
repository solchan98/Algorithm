# 동전 0, Silver2

## coint, price, coins 받아오기
coin, price = map(int, input().split())
coins = []
count = 0
for i in range(coin):
    coins.append(int(input()))
coins.reverse()

## 내림차순으로 확인
for i in coins:
    count += price // i
    price %= i

print(count)