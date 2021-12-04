package Programmers.Level1;
/** 2021-카카오-채용연계형-인턴십*/
import java.util.HashMap;

public class 숫자_문자열과_영단어 {

    public static void main(String[] args) {
        Solution81301 solution81301 = new Solution81301();
        System.out.println(solution81301.solution("one4sevenninethreezero"));
    }

}

class Solution81301 {
    public int solution(String s) {
        HashMap<Integer, String> hashMap = setNumberHashMap();
        for(int i = 0; i < hashMap.size(); i++) {
            if(s.contains(hashMap.get(i))) {
                s = s.replace(hashMap.get(i), String.valueOf(i));
            }
        }
        return Integer.parseInt(s);
    }

    private HashMap<Integer, String> setNumberHashMap() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0, "zero"); hashMap.put(1, "one"); hashMap.put(2, "two"); hashMap.put(3, "three");
        hashMap.put(4, "four"); hashMap.put(5, "five"); hashMap.put(6, "six"); hashMap.put(7, "seven");
        hashMap.put(8, "eight"); hashMap.put(9, "nine");
        return hashMap;
    }
}
