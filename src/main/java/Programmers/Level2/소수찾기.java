package Programmers.Level2;

import java.util.HashSet;

public class 소수찾기 {

    public static void main(String[] args) {
        Solution42839 solution42839 = new Solution42839();
        System.out.println(solution42839.solution("011"));
    }
}

class Solution42839 {
    public int solution(String numbers) {
        int result = 0;
        HashSet<Integer> numSet = new HashSet<>();
        getNumListThroughPerm("", numbers, numSet);
        for (Integer num: numSet) {
            result += this.isPrime(num) ? 1 : 0;
        }
        return result;
    }

    public void getNumListThroughPerm(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++){
            getNumListThroughPerm(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }

    private boolean isPrime(int num){
        for(int i = 2; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return num > 1;
    }
}