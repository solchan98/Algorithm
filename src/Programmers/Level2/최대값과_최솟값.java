package Programmers.Level2;

import java.util.Arrays;

public class 최대값과_최솟값 {

    public static void main(String[] args) {
        Solution12939 solution12939 = new Solution12939();
        String result = solution12939.solution("-1 -2 -3 -4");
        System.out.println(result);
    }
}

class Solution12939 {
    public String solution(String s) {
        String[] strList = s.split(" ");
        int intList[] = new int[strList.length];

        for(int i = 0; i < strList.length; i++) {
            intList[i] = Integer.parseInt(strList[i]);
        }
        int max = Arrays.stream(intList).max().getAsInt();
        int min = Arrays.stream(intList).min().getAsInt();
        return min + " " + max;
    }
}
