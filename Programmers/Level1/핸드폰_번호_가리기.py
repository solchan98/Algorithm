## 핸드폰 번호 가리기
# 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12948

ex1 = "01033334444" # 입력 예시1, 기대 출력 : *******4444
ex2 = "027778888" # 입력 예시2, 기대 출력 : *****8888

phone_number = ex2

s_len = len(phone_number) - 4 ## 뒷 4자리 제외한 길이
result = '*' * s_len + phone_number[-4:]
print(result)

