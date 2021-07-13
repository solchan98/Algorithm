# 나누기

## 입출력 n, f
n = input()
f = int(input())
a = int(n[:-2] + '00')
while True:
    if a % f == 0:
        break
    a += 1
print(str(a)[-2:])