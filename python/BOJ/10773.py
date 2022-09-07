# 제로, Silver4

cnt = int(input())
m = []

for i in range(cnt):
    t = int(input())
    if t == 0 :
        m.pop()
    else:
        m.append(t)

print(sum(m))