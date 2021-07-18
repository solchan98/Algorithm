# 다이얼

num = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

s = list(input())
time = 0

for i in range(len(s)):
    for j in num:
        if s[i] in j:
            time += num.index(j) + 3
            
print(time)