package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B1987 {

    static int R,C;
    static String[][] map;
    static Set<String> visitedAlphabetSet;
    static boolean[][] visited;

    static int res = 1;

    static int[] dw = {0, 0, -1, 1};
    static int[] dh = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0, 0);
        System.out.println(res);
    }

    private static boolean isMovable(int w, int h) {
        return w < R && w >= 0 && h < C && h >= 0;
    }

    private static boolean checkIsVisited(int w, int h) {
        return visitedAlphabetSet.contains(map[w][h]);
    }

    private static void dfs(int w, int h, int cnt) {
        boolean isVisited = checkIsVisited(w, h);
        if (isVisited){
            res = Math.max(res, cnt);
        } else {
            visitedAlphabetSet.add(map[w][h]);
            for (int idx = 0; idx < 4; idx++) {
                int nw = w + dw[idx];
                int nh = h + dh[idx];
                if (isMovable(nw, nh)) {
                    dfs(nw, nh, cnt + 1);
                }
            }
            visitedAlphabetSet.remove(map[w][h]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] wh = br.readLine().split(" ");
        R = Integer.parseInt(wh[0]);
        C = Integer.parseInt(wh[1]);

        map = new String[R][C];
        visited = new boolean[R][C];

        visitedAlphabetSet = new HashSet<>();

        for (int idx = 0; idx < R; idx++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < strings.length; j++) {
                map[idx][j] = strings[j];
            }
        }
    }
}
