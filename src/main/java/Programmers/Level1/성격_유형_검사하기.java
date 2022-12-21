package Programmers.Level1;

import java.util.*;

public class 성격_유형_검사하기 {

    public static void main(String[] args) {}

    public String solution(String[] survey, int[] choices) {
        List<String> typeGroupList = List.of(
                "RT", "CF", "JM", "AN");

        Map<String, Integer> map = new HashMap<>(8);
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int idx = 0; idx < survey.length; idx++) {
            String[] types = survey[idx].split("");
            if (choices[idx] < 4) {
                map.put(types[0], map.get(types[0]) + Math.abs(choices[idx] - 4));
            } else if (choices[idx] > 4){
                map.put(types[1], map.get(types[1]) + choices[idx] - 4);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String typeGroup: typeGroupList) {
            String[] types = typeGroup.split("");
            if (map.get(types[0]) >= map.get(types[1])) {
                sb.append(types[0]);
            } else {
                sb.append(types[1]);
            }
        }
        return sb.toString();
    }
}
