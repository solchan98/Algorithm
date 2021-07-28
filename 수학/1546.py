# 평균

cnt = int(input())
scores = list(map(int, input().split()))
maxScore = int(max(scores))

for i in range(cnt):
    scores[i] = scores[i]/maxScore *100

print(sum(scores) / cnt)