## 구현
# 상하좌우
# 책 해설과 다른 풀이

n = 5
move = ['R', 'R', 'R', 'U', 'D', 'D']

m_loc = { # 사람의 위치 및 초기 위치 설정
    'x': 1,
    'y': 1,
}

for loc in move:
    if loc == 'R' and m_loc['x'] + 1 <= n:
        m_loc['x'] += 1
    elif loc == 'L' and m_loc['x'] - 1 > 0:
        m_loc['x'] -= 1
    elif loc == 'U' and m_loc['y'] - 1 > 0:
        m_loc['y'] -= 1
    elif loc == 'D' and m_loc['y'] + 1 <= n:
        m_loc['y'] += 1

print(m_loc['y'], m_loc['x'])

