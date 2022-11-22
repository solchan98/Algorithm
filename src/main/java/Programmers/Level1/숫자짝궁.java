package Programmers.Level1;

import java.util.*;

public class 숫자짝궁 {

    public static void main(String[] args) {}

    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> visited = new HashMap<>(9);

        for (String tX: X.split("")) {
            boolean isContains = visited.containsKey(tX);
            int value = isContains ? visited.get(tX) + 1 : 1;
            visited.put(tX, value);
        }

        for (String tY: Y.split("")) {
            if (visited.containsKey(tY) && visited.get(tY) != 0) {
                sb.append(String.valueOf(tY));
                visited.put(tY, visited.get(tY) - 1);
            }
        }

        if (checkZero(sb.toString())) {
            return "0";
        } else if (sb.toString().equals("")) {
            return "-1";
        } else {
            String[] strings = sb.toString().split("");
            sb = new StringBuilder();
            Arrays.sort(strings, (i1, i2) -> i2.compareTo(i1));
            for (String str: strings) {
                sb.append(str);
            }
            return sb.toString();
        }
    }

    private boolean checkZero(String str) {
        for (String s: str.split("")) {
            if (!s.equals("0")) return false;
        }
        return true;
    }
}
