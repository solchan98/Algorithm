# 괄호, Silver4

cnt = int(input())

for i in range(cnt):
    check = 0
    vps = list(input())
    for c in vps:
        if check == -1: # ())인 경우
            break
        if c == '(':
            check += 1
        elif c == ')':
            check -= 1
        else:
            continue
    if check != 0:
        print("NO")
    else:
        print("YES")