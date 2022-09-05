import sys

input = sys.stdin.readline
str = input()

split_list = str.split("-")

result = 0

for i in range(0, len(split_list)):
    temp = 0
    number_list = split_list[i].split("+")

    for number in number_list:
        temp += int(number)

    if i == 0:
        result = temp
    else:
        result -= temp

print(result)


