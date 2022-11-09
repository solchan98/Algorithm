package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2156 {

    static int juiceCnt;
    static int[] juiceArr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        init();

        dp[1] = juiceArr[1];
        if (juiceCnt > 1) {
            dp[2] = juiceArr[1] + juiceArr[2];
        }


        for (int i = 3; i <= juiceCnt; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + juiceArr[i], dp[i - 3] + juiceArr[i - 1] + juiceArr[i]));

        }

        System.out.println(dp[juiceCnt]);

    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        juiceCnt = Integer.parseInt(br.readLine());
        juiceArr = new int[juiceCnt + 1];
        dp = new int[juiceCnt + 1];
        for (int idx = 1; idx <= juiceCnt; idx++) {
            juiceArr[idx] = Integer.parseInt(br.readLine());
        }
    }
}
