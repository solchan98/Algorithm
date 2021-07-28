# OX퀴즈

cnt = int(input())

score = []
result = []

for i in range(cnt):
    num = 0
    score.append(list(input()))
    result.append(0)
    for s in score[i]:
        if s == 'O':
            num += 1
        else:
            num = 0
        result[i] += num
        
for i in result:
    print(i)