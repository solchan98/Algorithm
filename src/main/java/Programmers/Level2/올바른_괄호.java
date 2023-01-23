package Programmers.Level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호 {
    public static void main(String[] args) {}

    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char bracket: s.toCharArray()) {
            if (!deque.isEmpty() && bracket == ')') {
                deque.pop();
                continue;
            }

            deque.add(bracket);
        }

        return deque.size() == 0;
    }
}
