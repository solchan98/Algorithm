package Programmers.Level2;

public class 카펫 {
    public static void main(String[] args) {
        Solution42842 solution42842 = new Solution42842();
        int[] solution = solution42842.solution(24, 24);
        System.out.println("[" + solution[0] + ", " + solution[1] + "]");
    }
}

class Solution42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int sum = brown + yellow;

        for(int i = 3; i < sum; i++) {
            int col = sum / i;
            int row = sum / col;

            int yellowCol = col - 2;
            int yellowRow = row - 2;

            if(yellowCol * yellowRow == yellow && col >= row) {
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }
        return answer;
    }
}
