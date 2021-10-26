package Programmers.Level2;

public class N개의_최소공약수 {

    public static void main(String[] args) {
        Solution12953 solution12953 = new Solution12953();
        int result = solution12953.solution(new int[]{2, 6, 8, 14});
        System.out.println(result);
    }
}

class Solution12953 {
    public int solution(int[] arr) {
        return getLCM(arr);
    }

    private int getGCD(int num1, int num2) { // Greatest Common Denominator
        int temp = 0;
        while (num2 != 0) {
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }

    private int getLCM(int[] arr) { // Least(lowest) Common Multiple
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int gcd = getGCD(result, arr[i]);
            result *= arr[i] / gcd;
        }
        return result;
    }
}
