package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1149 {

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;
    static int houseCnt;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        init();
        for (int idx = 1; idx < houseCnt; idx++) {
            dp[RED][idx] = cost[RED][idx] + Math.min(dp[GREEN][idx - 1], dp[BLUE][idx - 1]);
            dp[GREEN][idx] = cost[GREEN][idx] + Math.min(dp[RED][idx - 1], dp[BLUE][idx - 1]);
            dp[BLUE][idx] = cost[BLUE][idx] + Math.min(dp[RED][idx - 1], dp[GREEN][idx - 1]);
        }
        System.out.println(Math.min(Math.min(dp[RED][houseCnt - 1], dp[GREEN][houseCnt - 1]), dp[BLUE][houseCnt - 1]));
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        houseCnt = Integer.parseInt(br.readLine());
        cost = new int[3][houseCnt];
        dp = new int[3][houseCnt];

        for (int idx = 0; idx < houseCnt; idx++) {
            String[] strings = br.readLine().split(" ");
            cost[RED][idx] = Integer.parseInt(strings[0]);
            cost[GREEN][idx] = Integer.parseInt(strings[1]);
            cost[BLUE][idx] = Integer.parseInt(strings[2]);
        }

        dp[RED][0] = cost[RED][0];
        dp[GREEN][0] = cost[GREEN][0];
        dp[BLUE][0] = cost[BLUE][0];

        dp[RED][1] = Math.min(cost[RED][1] + dp[GREEN][0], cost[RED][1] + dp[BLUE][0]);
        dp[GREEN][1] = Math.min(cost[GREEN][1] + dp[RED][0], cost[GREEN][1] + dp[BLUE][0]);
        dp[BLUE][1] = Math.min(cost[BLUE][1] + dp[GREEN][0], cost[BLUE][1] + dp[RED][0]);
    }
}
