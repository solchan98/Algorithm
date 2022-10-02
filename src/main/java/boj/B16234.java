package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16234 {

    static int N, L, R;
    static int[][] world;
    static boolean[][] visited;
    static List<Node> willMoveList;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        int result = move();
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);
        world = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int move() {
        int result = 0;
        while (true) {
            boolean movable = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (willMoveList.size() > 1) {
                            movePopulation(sum);
                            movable = true;
                        }
                    }
                }
            }
            if (!movable) return result;
            result += 1;
        }
    }

    private static int bfs(int r, int c) {
        Deque<Node> deque = new ArrayDeque<>();
        willMoveList = new ArrayList<>();
        deque.add(new Node(r, c));
        visited[r][c] = true;
        willMoveList.add(new Node(r, c));

        int sum = world[r][c];
        while (!deque.isEmpty()) {
            Node node = deque.remove();

            for (int idx = 0; idx < 4; idx++) {
                int nr = node.r + dx[idx];
                int nc = node.c + dy[idx];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    int condition = Math.abs(world[nr][nc] - world[node.r][node.c]);
                    if (L <= condition && condition <= R) {
                        deque.add(new Node(nr, nc));
                        willMoveList.add(new Node(nr, nc));
                        sum += world[nr][nc];
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return sum;
    }

    private static void movePopulation(int sum) {
        int avg = sum / willMoveList.size();
        willMoveList.forEach((node) -> world[node.r][node.c] = avg);
    }
}
