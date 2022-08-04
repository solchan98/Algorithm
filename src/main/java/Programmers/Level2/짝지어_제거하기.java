package Programmers.Level2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        Solution12973 solution12973 = new Solution12973();
        System.out.println(solution12973.solution("baabbb"));

    }
}

class Solution12973
{
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }
}
