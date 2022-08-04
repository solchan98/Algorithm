package Programmers.Level2;

import java.util.*;

public class 괄호_변환 {
    int index;

    boolean isCorrect(String str) {
        int left = 0;
        int right = 0;
        boolean correct = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
                stack.push('(');
            } else {
                right++;
                if (stack.isEmpty()) {
                    correct = false;
                } else {
                    stack.pop();
                }
            }
            if (left == right) {
                index = i + 1;
                return correct;
            }
        }

        return correct;
    }

    public String solution(String p) {
        if (p.isEmpty())
            return p;

        boolean correct = isCorrect(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        if (correct) {
            return u + solution(v);
        }

        String answer = "(" + solution(v) + ")";
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                answer += ")";
            } else {
                answer += "(";
            }
        }

        return answer;
    }
}
