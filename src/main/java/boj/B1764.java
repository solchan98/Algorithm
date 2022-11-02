package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B1764 {

    static BufferedReader br;

    static int N;
    static int M;
    static Set<String > nameSet;
    static List<String> res;

    public static void main(String[] args) throws IOException {
        init();
        getNames();
        print();
    }

    private static void getNames() throws IOException {
        for (int idx = 0; idx < N; idx++) {
            nameSet.add(br.readLine());
        }

        for (int idx = 0; idx < M; idx++) {
            String name = br.readLine();
            if (nameSet.contains(name)) {
                res.add(name);
            }
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");
        N = Integer.parseInt(strings[0]);
        M = Integer.parseInt(strings[1]);

        res = new ArrayList<>(N);
        nameSet = new HashSet<>(N);
    }

    private static void print() {
        System.out.println(res.size());

        res.sort(String::compareTo);

        for (String name: res) {
            System.out.println(name);
        }
    }
}
