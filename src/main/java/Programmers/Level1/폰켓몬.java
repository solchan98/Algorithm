package Programmers.Level1;

import java.util.Arrays;

public class 폰켓몬 {
    public static void main(String[] args) {
        Solution1845 solution1845 = new Solution1845();
        System.out.println(solution1845.solution(new int[] {3,3,3,2,2,2}));
    }
}

class Solution1845 {
    public int solution(int[] nums) {
        return getSelectableCnt(nums);
    }

    private int getSelectableCnt(int[] nums) {
        int monsterCnt = (int) Arrays.stream(nums).distinct().count();
        int getAbleCnt =  getGetAbleCnt(nums);
        return Math.min(monsterCnt, getAbleCnt);
    }

    private int getGetAbleCnt(int[] nums) {
        return nums.length / 2;
    }
}