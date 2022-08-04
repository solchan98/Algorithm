package Programmers.Level1;

import java.util.Arrays;

public class 최대공약수와_최소공배수 {

    public static void main(String[] args) {
        Solution12940 solution12940 = new Solution12940();
        System.out.println(Arrays.toString(solution12940.solution(2, 5)));

    }
}

class Solution12940 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int temp = 1;
        int gcd= n * m;
        while(temp != 0){
            temp = m % n;
            m = n;
            n = temp;
        }
        answer[0] = m;
        answer[1] = gcd / m;
        return answer;
    }
}
