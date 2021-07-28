# 사분면 고르기

x = int(input())
y = int(input())

def solution(a, b):
    if x > 0:
        if y > 0:
            return 1
        else:
            return 4
    else:
        if y > 0:
            return 2
        else:
            return 3

print(solution(x, y))