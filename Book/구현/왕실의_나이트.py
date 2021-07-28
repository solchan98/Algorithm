## 구현
# 왕실의 나이트

# 현재 말의 위치
# 말의 이동은 L방식
horse = {
    'row': 1,
    'colume': 1
}
result = 0

steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

for step in steps:
    next_row = horse['row'] + step[0]
    next_column = horse['colume'] + step[1]

    if next_row >= 1 and next_row <= 8 and next_column >= 1 and next_column <= 8:
        result += 1


print(result)