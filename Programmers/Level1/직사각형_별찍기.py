## 직사각형 별찍기
# 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12969

ex1 = {'x' : 5, 'y' : 3} # 입력 예시1, 기대 출력 : 5 x 3
ex2 = {'x' : 6, 'y' : 4} # 입력 예시2, 기대 출력 : 6 x 4

x_y = ex2
x_star = ''


for i in range(x_y['x']):
    x_star += '*'
for i in range(x_y['y']):
    print(x_star)
