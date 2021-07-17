# 상수

def getReverse(exNum):
    exNum = list(exNum)
    exNum.reverse()
    return int(''.join(exNum))

result = []
fulNum = list(input().split(' '))

for i in fulNum:
    result.append(getReverse(i))

print(max(result))