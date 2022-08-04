package Programmers.Level1;

import java.util.Arrays;

public class 예산 {
    public static void main(String[] args) {
        Solution12982 solution12982 = new Solution12982();
        System.out.println(solution12982.solution(new int[]{1,3,2,5,4}, 9));

    }
}

class Solution12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int price : d) {
            if(budget - price < 0) break;
            budget -= price;
            answer++;
        }
        return answer;
    }
}