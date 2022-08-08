package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    int[][] count;
    boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new boolean[maps.length][maps[0].length];
        count = new int[maps.length][maps[0].length];

        bfs(maps);
        answer = count[maps.length-1][maps[0].length-1];

        return answer == 0 ? -1 : answer;
    }

    public void bfs(int[][] maps){
        int x = 0;
        int y = 0;
        visited[x][y] = true;
        count[x][y] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1)
                    continue;

                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    count[nx][ny] = count[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
