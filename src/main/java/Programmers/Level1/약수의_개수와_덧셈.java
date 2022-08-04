package Programmers.Level1;

public class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        Solution77884 solution77884 = new Solution77884();
        System.out.println(solution77884.solution(13, 17));
    }
}

class Solution77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int num = left, cnt = 0; num <= right; num++, cnt = 0) {
            for(int j = 1; j <= num; j++) {
                if(checkDivisor(j, num)) {
                    cnt++;
                }
            }
            answer += cnt % 2 == 0 ? num : -num;
        }
        return answer;
    }

    private boolean checkDivisor(int j, int num) {
        return num % j == 0;
    }
}
