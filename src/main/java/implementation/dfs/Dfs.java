package implementation.dfs;

import java.util.*;

public class Dfs {

    public static void main(String[] args) {
        int nodeCnt = 6;
        int start = 1;
        int [][] edgeList = {{0, 1}, {0, 3}, {3, 4}, {3, 6}, {6, 5}};
        boolean[] visited = new boolean[nodeCnt + 1];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            adjList.add(new LinkedList<>());
        }
        for (int[] edge: edgeList) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        dfs(start, adjList, visited);
    }

    public static void dfs(int v, List<List<Integer>> adjList, boolean[] visited) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(v);
        while(!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
                for (int i : adjList.get(current)) {
                    if (!visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }
}