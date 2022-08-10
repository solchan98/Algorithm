package Programmers.Level2;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int index = 0;

        while(answer.length() != number.length() - k) {
            int target = k + answer.length() + 1;
            int max = 0;
            for (int j = index; j < target; j++) {
                if (max < Character.getNumericValue(number.charAt(j))) {
                    max = Character.getNumericValue(number.charAt(j));
                    index = j + 1;
                }
                if (max == 9) break;
            }
            answer.append(String.valueOf(max));
        }
        return answer.toString();
    }
}
