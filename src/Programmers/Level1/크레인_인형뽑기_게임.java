package Programmers.Level1;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    public static void main(String[] args) {
        int[][] board = new int[][]{{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};
        Solution64061 solution64061 = new Solution64061();
        int result = solution64061.solution(board, moves);
        System.out.println(result);
    }
}

class Solution64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int move: moves) {
            for(int i = 0; i < board.length; i++) {
                int doll = board[i][move - 1];
                if(board[i][move -1] != 0) {
                    if(stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
