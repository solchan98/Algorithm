# ATM , Silver3

cnt = int(input())
times = list(map(int, input().split()))
wait = 0
result = []

## time 오름차순 정렬
times.sort();

for time in times:
    wait += time
    result.append(wait)

print(sum(result))