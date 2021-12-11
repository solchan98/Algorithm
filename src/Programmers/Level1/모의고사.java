package Programmers.Level1;

import java.util.*;

public class 모의고사 {

    public static void main(String[] args){
        Solution42840 solution42840 = new Solution42840();
        System.out.println(Arrays.toString(solution42840.solution(new int[]{1,3,2,4,2})));
    }
}

class Solution42840 {
    public int[] solution(int[] answers) {
        int[] peo1 = new int[]{1, 2, 3, 4, 5};
        int[] peo2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] peo3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] temp = new int[]{grading(answers, peo1), grading(answers, peo2), grading(answers, peo3)};
        return findRank(temp);
    }

    private int[] findRank(int[] temp) {
        List<Integer> result = new ArrayList<>(3);
        int max = Arrays.stream(temp).max().getAsInt();
        for(int i = 0; i < temp.length; i++) {
            if (temp[i] == max) {
                result.add(i + 1);
            }
        }
        return convertListToArray(result);
    }

    private int[] convertListToArray(List<Integer> result) {
        int[] arrayResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }

    private int grading(int[] answers, int[] peo) {
        int result = 0;
        for(int i = 0, j = 0; i < answers.length; i++, j++) {
            if(j == peo.length) {
                j = 0;
            }
            if(answers[i] == peo[j]) {
                result++;
            }
        }
        return result;
    }
}
