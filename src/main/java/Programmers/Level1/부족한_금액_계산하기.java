package Programmers.Level1;

public class 부족한_금액_계산하기 {
    public static void main(String[] atgs) {
        Solution82612 solution82612 = new Solution82612();
        System.out.println(solution82612.solution(3, 20 ,4));
    }
}

class Solution82612 {
    public long solution(int price, int money, int count) {
        long realPrice = 0;
        for(int i = 1; i <= count; i++) {
            realPrice += (long) price * i;
        }
        long answer = realPrice - money;
        if(answer > 0) {
            return answer;
        } else {
            return 0;
        }
    }
}