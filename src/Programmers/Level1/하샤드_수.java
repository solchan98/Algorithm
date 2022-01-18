package Programmers.Level1;

public class 하샤드_수 {

    public static void main(String[] args) {
        Solution12947 solution12947 = new Solution12947();
        System.out.println(solution12947.solution(11));

    }
}

class Solution12947 {
    public boolean solution(int x) {
        int allSum = 0;
        String[] strList = String.valueOf(x).split("");
        for(String str: strList) {
            allSum += Integer.parseInt(str);
        }
        return x % allSum == 0;
    }
}
