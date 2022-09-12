package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int change = 1000 - Integer.parseInt(st.nextToken());
        int[] yens = { 500, 100, 50, 10, 5, 1 };
        int result = 0;

        for (int yen: yens) {
            result += change / yen;
            change = change % yen;
        }

        System.out.println(result);
    }
}
