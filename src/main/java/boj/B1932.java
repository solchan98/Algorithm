package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1932 {

    static int N;

    static int[][] numArr;

    public static void main(String[] args) throws Exception {
        init();
        for (int idx = numArr.length - 1; idx > 0; idx--) {
            for (int jdx = 0; jdx < idx; jdx++) {
                numArr[idx - 1][jdx] += Math.max(numArr[idx][jdx], numArr[idx][jdx + 1]);
            }
        }
        System.out.println(numArr[0][0]);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = new int[N][];

        for (int idx = 0; idx < N; idx++) {
            String[] strings = br.readLine().split(" ");
            numArr[idx] = new int[strings.length];
            for (int jdx = 0; jdx < strings.length; jdx++) {
                numArr[idx][jdx] = Integer.parseInt(strings[jdx]);
            }
        }
    }
}
