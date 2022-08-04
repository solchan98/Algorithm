package Programmers.Level1;

import java.util.Arrays;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        Solution86051 solution86051 = new Solution86051();
        System.out.println(solution86051.solutionV1(new int[]{5,8,4,0,6,7,9}));
        System.out.println(solution86051.solutionV2(new int[]{5,8,4,0,6,7,9}));
    }
}

class Solution86051 {
    // 계수 정렬을 이용한 풀이
    public int solutionV1(int[] numbers) {
        int answer = 0;
        int[] resultList = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Arrays.sort(numbers);
        for (int number : numbers) {
            resultList[number] = number;
        }
        for(int i = 1; i < resultList.length; i++) {
            if(resultList[i] == 0) {
                answer += i;
            }
        }
        return answer;
    }

    // 총 합을 통한 풀이 (0 ~ 9의 총합은 45이다.)
    public int solutionV2(int[] numbers) {
        int answer = 45;
        return answer - Arrays.stream(numbers).sum();
    }
}
