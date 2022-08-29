def solution(answers):
    answer = []
    user_list = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]

    max_cnt = 0
    for index, user in enumerate(user_list):
        cnt = check_answer(user, answers)
        if cnt > max_cnt:
            max_cnt = cnt
            answer = [index + 1]
        elif cnt == max_cnt:
            answer.append(index + 1)

    return answer


def check_answer(user_answers, answers):
    cnt = 0
    j = 0
    for answer in answers:
        if user_answers[j] == answer:
            cnt += 1
        if j == len(user_answers) - 1:
            j = 0
        else:
            j += 1
    return cnt
