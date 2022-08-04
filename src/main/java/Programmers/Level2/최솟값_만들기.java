package Programmers.Level2;

import java.util.Arrays;

public class 최솟값_만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(result);
    }
}

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[(B.length -1) - i];
        }
        return answer;
    }
}
