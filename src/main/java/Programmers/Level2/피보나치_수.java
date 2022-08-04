package Programmers.Level2;

public class 피보나치_수 {
    public int solution(int n) {
        int[] numArr = new int[n + 1];

        numArr[0] = 0;
        numArr[1] = 1;

        for (int index = 2; index < n + 1; index++) {
            numArr[index] = (numArr[index - 1] + numArr[index - 2]) % 1234567;
        }

        return numArr[n];
    }
}
