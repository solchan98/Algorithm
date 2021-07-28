# 설탕 배달

kg = int(input())

def solution(sugar):
    result ={ 'bag' : 0, 'result' : 0 }
    while sugar > 0:
        if sugar % 5 == 0:
            result['bag'] += sugar / 5
            result['result'] = 1
            break
        sugar -= 3
        result['bag'] += 1
    return result;

result = solution(kg)

if result['result'] == 1:
    print(int(result['bag']))
else:
    print(-1)