package Programmers.Level1;

public class 콜라문제 {

    public static void main(String[] args) {}

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int leftover = n % a;
            n = (n / a) * b;
            answer += n;
            n += leftover;
        }
        return answer;
    }
}
