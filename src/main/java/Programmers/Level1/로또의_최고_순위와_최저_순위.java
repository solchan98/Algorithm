package Programmers.Level1;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        Solution77484 solution77484 = new Solution77484();
        System.out.println(Arrays.toString(solution77484.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));


    }
}

class Solution77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int minCnt = 0;
        int maxCnt = 0;
        for (int lotto : lottos) {
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    minCnt += 1;
                    maxCnt += 1;
                }
            }
            if (lotto == 0) {
                maxCnt += 1;
            }
        }
        int maxRank = getRank(maxCnt);
        int minRank = getRank(minCnt);
        return new int[]{maxRank, minRank};
    }

    private int getRank(int cnt) {
        switch (cnt) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}