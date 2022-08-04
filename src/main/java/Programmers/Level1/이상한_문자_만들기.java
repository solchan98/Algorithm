package Programmers.Level1;

public class 이상한_문자_만들기 {

    public static void main(String[] args) {
        Solution12930 solution12930 = new Solution12930();
        System.out.println(solution12930.solution("try DDDDd      hello world"));
    }
}

class Solution12930 {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        for(int i = 0; i < s.length(); i++, index++) {
            if(index % 2 == 0){
                result.append(Character.toUpperCase(s.charAt(i)));
            } else {
                result.append(Character.toLowerCase(s.charAt(i)));
            }
            if(s.charAt(i) == ' ') {
                index = -1;
            }
        }
        return result.toString();
    }
}
