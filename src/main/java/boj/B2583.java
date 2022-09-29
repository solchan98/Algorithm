package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2583 {

    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int w;
    static int h;
    static List<Integer> cntList = new ArrayList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        init();

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (map[i][j] != 1) {
                    int cnt = bfs(i, j);
                    cntList.add(cnt);
                }
            }
        }

        Collections.sort(cntList);
        System.out.println(cntList.size());
        cntList.forEach((cnt) -> System.out.print(cnt + " ") );
    }

    private static int bfs(int x, int y) {
        int cnt = 0;
        Deque<Dot> deque = new ArrayDeque<>();
        deque.add(new Dot(x, y));
        map[x][y] = 1;

        while (!deque.isEmpty()) {
            Dot dot = deque.remove();
            for (int i = 0; i < 4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];

                if (nx < w && nx >= 0 && ny < h && ny >= 0 && map[nx][ny] != 1) {
                    map[nx][ny] = 1;
                    deque.add(new Dot(nx, ny));
                    cnt++;
                }
            }
        }

        return cnt + 1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        w = Integer.parseInt(input.split(" ")[0]);
        h = Integer.parseInt(input.split(" ")[1]);
        int n = Integer.parseInt(input.split(" ")[2]);

        map = new int[w][h];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            for (int ew = Integer.parseInt(s[1]); ew < Integer.parseInt(s[3]); ew++) {
                for (int eh = Integer.parseInt(s[0]); eh < Integer.parseInt(s[2]); eh++) {
                    map[ew][eh] = 1;
                }
            }
        }
    }
}