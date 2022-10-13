package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10819 {

    static int N;
    static int[] arr;
    static int[] oneOfPermutation;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        permute(arr, oneOfPermutation, visited, 0);
        System.out.println(max);
    }

    private static void calc(int[] arr) {
        int res = 0;
        for (int idx = 0; idx < arr.length - 1; idx++) {
            res += Math.abs(arr[idx] - arr[idx + 1]);
        }
        max = Math.max(max, res);
    }

    private static void permute(int[] arr, int[] oneOfPermutation, boolean[] visited, int depth) {
        if (depth == N) {
            calc(oneOfPermutation);
        } else {
            for (int idx = 0; idx < N; idx++) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    oneOfPermutation[depth] = arr[idx];
                    permute(arr, oneOfPermutation, visited, depth + 1);
                    visited[idx] = false;
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        oneOfPermutation = new int[N];
        visited = new boolean[N];

        String[] strings = br.readLine().split(" ");
        for (int idx = 0; idx < N; idx++) {
            arr[idx] = Integer.parseInt(strings[idx]);
        }
    }
}
