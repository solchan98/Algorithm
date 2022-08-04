package Programmers.Level2;

public class 일이사_나라의_숫자 {
    StringBuilder answer = new StringBuilder();
    private void recursive(int number) {
        if (number == 1) {
            answer.append(1);
        } else if (number == 2) {
            answer.append(2);
        } else if (number == 3 || number == 0) {
            answer.append(4);
        } else {
            recursive((number - 1) / 3);
            recursive(number % 3);
        }
    }

    public String solution(int n) {
        this.recursive(n);
        return answer.toString();
    }
}
