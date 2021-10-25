# 평균은 넘겠지

cnt = int(input())

for i in range(cnt):
    score = list(map(int, input().split()))
    num = 0
    if score[0] == len(score)-1:
        avg = (sum(score)-score[0]) / score[0]
    
    for j in range(1,len(score)):
        if avg < score[j]:
            num +=1
    print(round(num/score[0]*100, 3))