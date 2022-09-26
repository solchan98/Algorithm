package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class B10026 {

    static class Dot {
        int x;
        int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static char[][] redBlueMap;
    static int N;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        int basicAreaCnt = findArea(false);
        int redBlueAreaCnt = findArea(true);
        System.out.println(basicAreaCnt + " " + redBlueAreaCnt);
    }

    private static int findArea(boolean type) {
        int cnt = 0;
        visited = new boolean[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited[x][y]) {
                    bfs(x, y, type);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int x, int y, boolean type) {
        char[][] sMap = type ? redBlueMap : map;
        Deque<Dot> deque = new LinkedList<>();
        deque.offer(new Dot(x, y));
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            Dot dot = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];

                if (nx < N && nx >= 0 && ny < N && ny >= 0 && !visited[nx][ny]) {
                    if (sMap[nx][ny] == sMap[x][y]) {
                        deque.push(new Dot(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        redBlueMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                redBlueMap[i][j] = s.charAt(j);
                if (s.charAt(j) == 'G') redBlueMap[i][j] = 'R';
            }
        }
    }
}
