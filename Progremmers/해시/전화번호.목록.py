# 전화번호 목록, Level2

def solution(phone_book):
    answer = True
    phone_book.sort()
    for i in range(len(phone_book) - 1):
        if phone_book[i] in phone_book[i + 1]:
            if phone_book[i][0] == phone_book[i + 1][0]:
                answer = False
                break
    return answer

# 풀이
# 1. 정렬 (숫자 길이순)
# 2. phone_book의 길이 -1 만큼 for문 동작 / i + 1 연산을 위해
# 3. in 키워드를 통해 해당 번호가 있는지 판단
# 4. 해당 번호의 첫 번호와 매칭되는 phone_book의 첫 번호가 같은지 비교 / 12, 312 case 감별
# 5. 3, 4 조건에 걸리면 answer = False, 로직 종료
# #