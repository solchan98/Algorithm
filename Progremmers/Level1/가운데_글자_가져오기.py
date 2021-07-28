## 가운데 글자 가져오기
# 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12903

ex1 = "abcde" # # 입력 예시1, 기대 출력 : c
ex2 = "qwer" # # 입력 예시1, 기대 출력 : we

def solution(s):
    if(len(s) % 2 != 0):
        return s[len(s) // 2]
    else:
        return s[len(s) // 2 - 1 : len(s) // 2 + 1]

print(solution(ex1));
print(solution(ex2));


