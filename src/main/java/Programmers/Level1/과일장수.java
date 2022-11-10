package Programmers.Level1;

import java.util.Arrays;

public class 과일장수 {

    public static void main(String[] args) {

    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] sc = new int[score.length];

        Arrays.sort(score);
        for (int idx = 0; idx < score.length; idx++) {
            sc[idx] = score[score.length - idx - 1];
        }

        int idx = 0;
        while (true) {
            if (idx + m > sc.length) break;

            answer += sc[idx + m - 1] * m;
            idx += m;
        }

        return answer;
    }
}
