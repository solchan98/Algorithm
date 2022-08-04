package Programmers.Level1;

import java.util.Arrays;

public class 비밀지도 {
    public static void main(String[] args) {

        Solution17681 solution17681 = new Solution17681();
        String[] result = solution17681.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});
        System.out.println(Arrays.toString(result));
    }
}


class Solution17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] binaryMap1 = getBinaryMap(n, arr1);
        String[] binaryMap2 = getBinaryMap(n, arr2);

        char[][] decode = decode(n, binaryMap1, binaryMap2);
        return getResult(n, decode);
    }

    private String[] getResult(int n, char[][] decode) {
        String[] result = new String[n];
        for(int i = 0; i < n; i++) {
            result[i] = String.valueOf(decode[i]);
        }
        return result;
    }

    private String[] getBinaryMap(int n, int[] arr1) {
        String[] binaryMap = new String[n];
        for(int i = 0; i < arr1.length; i++) {
            String s = String.format("%0" + n +"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            binaryMap[i] = s;
        }
        return binaryMap;
    }

    private char[][] decode(int n, String[] binaryMap1, String[] binaryMap2) {
        char[][] decode = initialize(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(binaryMap1[i].charAt(j) == binaryMap2[i].charAt(j) && binaryMap1[i].charAt(j) == '0') {
                    decode[i][j] = ' ';
                }
            }
        }

        return decode;
    }

    private char[][] initialize(int n) {
        char[][] decode = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(decode[i], '#');
        }
        return decode;
    }
}