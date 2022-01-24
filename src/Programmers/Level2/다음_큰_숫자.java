package Programmers.Level2;

public class 다음_큰_숫자 {
    public static void main(String[] args) {
        Solution12911 solution12911 = new Solution12911();
        System.out.println(solution12911.solution(15));
    }
}

class Solution12911 {
    public int solution(int n) {
        int oneCnt = getNumOneCnt(n);
        int i = n + 1;
        while(this.getNumOneCnt(i) != oneCnt) {
            i++;
        }
        return i;
    }

    private int getNumOneCnt(int n) {
        int cnt = 0;
        String s = Integer.toBinaryString(n);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}