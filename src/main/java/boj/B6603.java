package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B6603 {

    static final int k = 6;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            String[] numStr = s.split(" ");
            arr = new int[numStr.length - 1];
            for (int idx = 0; idx < Integer.parseInt(numStr[0]); idx++) {
                arr[idx] = Integer.parseInt(numStr[idx + 1]);
            }
            visited = new boolean[arr.length];
            combination(0, k);
            System.out.println();
        }
    }

    public static void combination(int start, int cnt){
        if (cnt == 0) {
            int[] lotto = findCase(arr, visited);
            Arrays.sort(lotto);
            print(lotto);
        } else {
            for (int idx = start; idx < arr.length; idx++) {
                visited[idx] = true;
                combination(idx + 1, cnt - 1);
                visited[idx] = false;
            }
        }
    }

    private static int[] findCase(int[] arr, boolean[] visited) {
        int[] lotto = new int[k];
        for (int idx = 0, jdx = 0; idx < arr.length; idx++) {
            if (visited[idx]) {
                lotto[jdx] = arr[idx];
                jdx++;
            }
        }
        return lotto;
    }

    private static void print(int[] lotto) {
        for (int num: lotto) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
