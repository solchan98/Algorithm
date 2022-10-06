package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class B1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int caseCnt = Integer.parseInt(st.nextToken());

        for(int i = 0; i < caseCnt; i++) {
            String[] input =  br.readLine().split(" ");
            int te = te(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            System.out.println(te);
        }
    }

    private static int te(int cnt, int target) {
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < cnt; i++) deque.push(i);
        Integer p = deque.poll();
        if (Objects.isNull(p)) return 0;
        while (p != target) {
            result += 1;
            p = deque.poll();
            if (Objects.isNull(p)) return 0;
        }

        return result;
    }

}
