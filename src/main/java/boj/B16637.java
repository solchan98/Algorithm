package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B16637 {

    static int N, ans = Integer.MIN_VALUE;
    static List<Character> opList;
    static List<Integer> numList;

    public static void main(String[] args) throws IOException {
        init();
        dfs(numList.get(0),0);
        System.out.println(ans);
    }

    private static void dfs(int res, int idx) {
        if (idx >= N / 2) {
            ans = Math.max(ans, res);
            return;
        }

        int calc = calc(res, numList.get(idx + 1), opList.get(idx));
        dfs(calc, idx + 1);

        if (idx + 1 < N / 2) {
            int nextCalc = calc(numList.get(idx + 1), numList.get(idx + 2), opList.get(idx + 1));
            int curCalc = calc(res, nextCalc, opList.get(idx));
            dfs(curCalc, idx + 2);
        }
    }

    private static int calc(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return -1;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numList = new ArrayList<>();
        opList = new ArrayList<>();

        String[] strings = br.readLine().split("");

        for (int idx = 0; idx < N; idx++) {
            if (idx % 2 == 0) {
                numList.add(Integer.parseInt(strings[idx]));
            } else {
                opList.add((strings[idx].charAt(0)));
            }
        }
    }
}
