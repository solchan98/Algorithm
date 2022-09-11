package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int[] weightArr = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            weightArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weightArr);

        int max = 0;

        for (int i = 0; i < weightArr.length; i++) {
            int weight = weightArr[i] * (weightArr.length - i);
            if (weight > max) max = weight;
        }

        System.out.println(max);
    }
}