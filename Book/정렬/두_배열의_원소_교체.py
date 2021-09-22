# 두 배열의 원소 교체, 난이도 하

## Data
N, K = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()

B.sort(reverse=True)

for i in range(K):
    if(A[i] < B[i]):
        A[i], B[i] = B[i], A[i]
    else:
        break

print(sum(A));


# 풀이
# 1. Data 입력받기
# 2. A는 오름차순 정렬, B는 내림차순 정렬
# 3. 두 배열의 가장 첫 번째 원소부터 비교, K번 반복
# 3-1. A가 작으면 교체
# 3-2. B가 크면 종료, 
# 3-2-1. 두 배열 모두 각각 오름, 내림으로 정렬된 상태이기 때문에 B가 큰 순간이 오면 더 이상 A가 큰 경우는 없다.
# A의 모든 합 출력#
