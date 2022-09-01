def solution(participant, completion):
    dict = {}
    for p in participant:
        if p not in dict:
            dict[p] = 1
        else:
            dict[p] += 1

    for c in completion:
        dict[c] -= 1

    result = [key for key in dict if dict[key] > 0]
    return result[0]