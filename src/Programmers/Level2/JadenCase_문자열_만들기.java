package Programmers.Level2;

public class JadenCase_문자열_만들기 {

    public static void main(String[] args) {
        Solution12951 solution12951 = new Solution12951();
        System.out.println(solution12951.solution("     for the last            week  "));
    }
}

class Solution12951 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] charList = s.toLowerCase().toCharArray();
        boolean isBlank = true;

        for(char ch : charList) {
            answer.append(isBlank ? Character.toUpperCase(ch) : ch);
            isBlank = ch == ' ';
        }

        return answer.toString();
    }
}