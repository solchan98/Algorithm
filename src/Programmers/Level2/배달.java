package Programmers.Level2;

import java.util.*;

class Edge implements Comparable<Edge> {
    int dist;
    int vertex;

    public Edge(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }

    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
}

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<Edge>> graph = this.init(road);

        Map<Integer, Integer> distMap = this.dijkstra(graph, 1);

        return (int) distMap.values().stream().filter(v -> v <= K).count();
    }

    private Map<Integer, Integer> dijkstra(Map<Integer, List<Edge>> graph, int start) {
        Queue<Edge> queue = new PriorityQueue<>();
        Map<Integer, Integer> distMap = new HashMap<>();

        for (Integer key: graph.keySet()) {
            distMap.put(key, Integer.MAX_VALUE);
        }

        distMap.put(start, 0);
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            List<Edge> edgeList = graph.get(poll.vertex);

            for (Edge edge: edgeList) {
                if (distMap.get(edge.vertex) > edge.dist  + poll.dist) {
                    distMap.put(edge.vertex, edge.dist + poll.dist);
                    queue.add(new Edge(edge.vertex, edge.dist + poll.dist));
                }
            }


        }

        return distMap;
    }

    private Map<Integer, List<Edge>> init(int[][] road) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int index = 0; index < road.length; index++) {
            graph.put(road[index][0], new ArrayList<>());
            graph.put(road[index][1], new ArrayList<>());
        }

        for (int index = 0; index < road.length; index++) {
            graph.get(road[index][0]).add(new Edge(road[index][1], road[index][2]));
            graph.get(road[index][1]).add(new Edge(road[index][0], road[index][2]));
        }

        return graph;
    }
}