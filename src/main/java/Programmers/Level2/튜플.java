package Programmers.Level2;

import java.util.*;

public class 튜플 {
    public int[] solution(String s) {
        String[] strList = getStringTupleArray(s);
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (String str: strList) {
            String[] numList = str.substring(1, str.length() - 1).split(",");
            for (String num: numList) {
                linkedHashSet.add(Integer.valueOf(num.trim()));
            }
        }
        Integer[] resultArr = linkedHashSet.toArray(new Integer[0]);

        return Arrays.stream(resultArr).mapToInt(Integer::intValue).toArray();
    }

    private String[] getStringTupleArray(String s) {
        String[] strList = s.replaceAll("[{]", "").split("}");

        for (int i = 0; i < strList.length; i++) {
            String p = strList[i];
            if (p.charAt(0) == ',')
                p = strList[i].replaceFirst("[,]", "");
            strList[i] = Arrays.toString(p.split(","));
        }
        Arrays.sort(strList, (prev, cur) -> prev.length() - cur.length());
        return strList;
    }
}
