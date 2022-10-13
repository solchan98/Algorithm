package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        int n = 1;
        while(true) {
            if(s >= n) {
                s -= n;
            } else {
                break;
            }
            n++;
        }

        System.out.println(--n);
    }
}
