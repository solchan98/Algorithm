# 그룹 단어 체커

cnt = int(input())
result = 0
def checker(s):
    for i in range(len(s) - 1):
        if s[i] != s[i + 1]:
            if s[i] in s[i + 1:]:
                return 0
    return 1

for i in range(cnt):
    result += checker(list(input()))
print(result)