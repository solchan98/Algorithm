package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2146 {

    static class Dot {
        int x;
        int y;
        int dist;

        public Dot(int x, int y, int dist) {
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

        int cnt = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) setUpMap(i,j, cnt++);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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

    private static void setUpMap(int x, int y, int cnt) {
        map[x][y] = cnt;
        visited[x][y] = true;

        for (int index = 0; index < 4; index++) {
            int nx = x + dx[index];
            int ny = y + dy[index];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                map[nx][ny] = cnt;
                setUpMap(nx, ny, cnt);
            }
        }
    }

    private static void bfs(int x, int y) {
        Deque<Dot> deque = new ArrayDeque<>();
        deque.add(new Dot(x, y, 0));
        int curNum = map[x][y];
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            Dot dot = deque.remove();
            for (int i = 0; i < 4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] != curNum) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        deque.add(new Dot(nx, ny, dot.dist + 1));
                    } else {
                        min = Math.min(min, dot.dist);
                    }
                }
            }
        }
    }
}
