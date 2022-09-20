package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14502 {

    static class Dot {
        int x;
        int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, max;
    static List<Dot> virusList;
    static int[][] realMap;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };


    public static void main(String[] args) throws IOException {
        init();
        makeWall(0);
        System.out.println(max);
    }

    private static void spreadVirus() {
        int[][] map = copy(realMap);
        Deque<Dot> deque = new LinkedList<>();
        for (Dot virus: virusList) {
            deque.add(new Dot(virus.x, virus.y));
        }

        while (!deque.isEmpty()) {
            Dot v = deque.remove();
            int x = v.x;
            int y = v.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                boolean isValid = nx >= 0 && ny >= 0 && nx < N && ny < M;
                if ( isValid && map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    deque.add(new Dot(nx, ny));
                }
            }
        }
        int cnt = countSafeZone(map);
        max = Math.max(max, cnt);
    }

    private static void makeWall(int depth) {
        if (depth == 3) {
            spreadVirus();
        } else {
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (realMap[i][j] == 0) {
                        realMap[i][j] = 1;
                        makeWall(depth + 1);
                        realMap[i][j] = 0;
                    }
                }
            }
        }
    }

    private static int[][] copy(int[][] map) {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, M);
        }
        return copyMap;
    }

    private static int countSafeZone(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        virusList = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        realMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                realMap[i][j] = Integer.parseInt(st.nextToken());
                if (realMap[i][j] == 2) {
                    virusList.add(new Dot(i, j));
                }
            }
        }
    }
}
