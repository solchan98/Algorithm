# 오픈채팅방, 2019 KAKAO BLIND RECRUITMENT

## Commend
commend = ["Enter", "Leave", "Change"]    

def solution(record):
    result = []
    idName = {}
    visitLog = []
    for i in record:
        cmdLine = list(map(str, i.split(" ")))
        if cmdLine[0] == "Change":
            idName[cmdLine[1]] = cmdLine[2] 
        elif cmdLine[0] == "Enter":
            idName[cmdLine[1]] = cmdLine[2]
            visitLog.append({"id" : cmdLine[1], "message" : " 들어왔습니다."})
        elif cmdLine[0] == "Leave":
            visitLog.append({"id" : cmdLine[1], "message" : " 나갔습니다."})
    for i in visitLog:
        result.append(idName[i["id"]] + "님이" + i["message"])
    return result

# 풀이
# 1. Comment 설정
# 2. dict로 key : id, value : nickname 설정
# 3. Enter, Leave 명령어인 경우 visitLog에 id와 message dict로 각각 넣기
# 4. Change 명령어인 경우 해당 id key의 value를 변경
# 5. visitLog를 돌며 id를 idName의 해당되는 key를 찾아 value를 가져와 추가#