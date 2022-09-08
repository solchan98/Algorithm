package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        int[][] time = getTimeArrays();
        Arrays.sort(time, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int total = 0;
        int curEndTime = 0;

        for (int[] t: time) {
            if (t[0] >= curEndTime) {
                curEndTime = t[1];
                total++;
            }
        }

        System.out.println(total);
    }

    private static int[][] getTimeArrays() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        return time;
    }
}