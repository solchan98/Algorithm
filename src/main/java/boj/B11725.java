package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11725 {

    static int N;
    static List<List<Integer>> list;
    static boolean[] visited;
    static Map<Integer, Integer> result;

    public static void main(String[] args) throws IOException {

        init();
        bfs();
        for (int i = 2; i < N; i++) {
            System.out.println(result.get(i));
        }
    }

    private static void bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        while (!deque.isEmpty()) {
            Integer node = deque.remove();
            List<Integer> childrenList = list.get(node);
            visited[node] = true;
            for (Integer child: childrenList) {
                if (!visited[child]) {
                    result.put(child, node);
                    deque.add(child);
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()) + 1;

        list = new ArrayList<>(N);
        visited = new boolean[N];
        result = new HashMap<>(N);
        for (int i = 1; i <= N; i++) list.add(new ArrayList<>());

        for (int i = 1; i < N - 1; i++) {
            String[] s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            list.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
        }
    }
}
