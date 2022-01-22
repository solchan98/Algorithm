package Programmers.Level1;

public class 문자열_압축 {
    public static void main(String[] args) {
        Solution60057 solution60057 = new Solution60057();
        System.out.println(solution60057.solution("ababcdcdababcdcd"));
    }
}

class Solution60057 {
    public int solution(String s) {
        int result = s.length();
        for(int i = 1; i <= s.length() / 2; i++) {
            String comStr = getCompressedStr(s, i);
            result = Math.min(result, comStr.length());
        }
        return result;
    }

    private String getCompressedStr(String s, int end) {
        String comStr = "";
        String prevStr = "";
        int cnt = 1;
        for(int start = 0; start < s.length(); start += end) {
            String subStr = getSubString(s, start, end);
            if(subStr.equals(prevStr)) {
                cnt++;
            } else if(cnt > 1) {
               comStr += cnt + subStr;
               cnt = 1;
            } else {
                comStr += subStr;
            }
            prevStr = subStr;
        }
        if(cnt > 1) {
            comStr += cnt;
        }
        return comStr;
    }

    private String getSubString(String s, int start, int end) {
        String subStr;
        if(start + end > s.length()) {
            subStr = s.substring(start);
        } else {
            subStr = s.substring(start, start + end);
        }
        return subStr;
    }
}