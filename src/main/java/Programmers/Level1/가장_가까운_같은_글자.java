package Programmers.Level1;

import java.util.*;

public class 가장_가까운_같은_글자 {

    public static void main(String[] args) {}

    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>(s.length());
        int[] answer = new int[s.length()];

        String[] strList = s.split("");

        for (int idx = 0; idx < strList.length; idx++) {
            boolean isContains = map.containsKey(strList[idx]);
            answer[idx] = isContains ? idx - map.get(strList[idx]) : -1;
            map.put(strList[idx], idx);
        }
        return answer;
    }
}
