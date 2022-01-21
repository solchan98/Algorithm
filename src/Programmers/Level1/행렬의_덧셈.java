package Programmers.Level1;

import java.util.Arrays;

public class 행렬의_덧셈 {
    public static void Main(String[] args) {
        Solution12950 solution12950 = new Solution12950();
        System.out.println(
                "solution12950 = " + Arrays.deepToString(solution12950.solution(
                        new int[][]{ new int[]{1, 2}, new int[]{2, 3}},
                        new int[][]{ new int[]{3, 4}, new int[]{5, 6}}
                )));
    }

}

class Solution12950 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int col = arr1.length;
        int row = arr1[0].length;
        int[][] answer = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
