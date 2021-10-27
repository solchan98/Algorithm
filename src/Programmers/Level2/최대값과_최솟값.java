package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 최대값과_최솟값 {

    public static void main(String[] args) {
        Solution12939 solution12939 = new Solution12939();
        String result = solution12939.solution("-1 -2 -3 -4");
        System.out.println(result);
    }
}

class Solution12939 {
    public String solution(String s) {
        List<Integer> integerList = Arrays.stream(s.split(" "))
                .map(x -> Integer.parseInt(x)).collect(Collectors.toList());
        Integer max = integerList.stream().max(Comparator.naturalOrder()).get();
        Integer min = integerList.stream().min(Comparator.naturalOrder()).get();
        return min + " " + max;
    }
}
