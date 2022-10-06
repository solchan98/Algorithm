package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2146 {

    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) setUpMap(i,j, idx++);
                if (map[i][j] != 0) bfs(i, j);
            }
        }

        System.out.println(min);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void setUpMap(int x, int y, int idx) {
        map[x][y] = idx;
        visited[x][y] = true;

        for (int index = 0; index < 4; index++) {
            int nx = x + dx[index];
            int ny = y + dy[index];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                map[nx][ny] = idx;
                setUpMap(nx, ny, idx);
            }
        }
    }

    private static void bfs(int x, int y) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(x, y, 0));
        int current = map[x][y];
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            Node node = deque.remove();

            if (node.dist >= min) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] != current) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        deque.add(new Node(nx, ny, node.dist + 1));
                    } else {
                        min = Math.min(min, node.dist);
                    }
                }
            }
        }
    }
}
