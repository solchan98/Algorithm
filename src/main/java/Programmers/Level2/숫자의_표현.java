package Programmers.Level2;

public class 숫자의_표현 {
    public static void main(String[] args) {}

    public int solution(int n) {
        int answer = 0;
        for (int idx = 1; idx <= n; idx++) {
            if (exist(idx, n)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean exist(int start, int end) {
        int sum = 0;
        for (int idx = start; idx <= end; idx++) {
            sum += idx;
            if (sum == end) {
                return true;
            }

            if (sum > end) {
                break;
            }
        }
        return false;
    }
}
