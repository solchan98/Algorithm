package study;

import java.util.*;

class Edge implements Comparable<Edge>{
    int weigh;
    String vertex;
    Edge prev;

    @Override
    public int compareTo(Edge o) {
        return this.weigh - o.weigh;
    }

    public Edge(int weigh, String vertex) {
        this.weigh = weigh;
        this.vertex = vertex;
        this.prev = null;
    }

    public Edge(int weigh, String vertex, Edge prev) {
        this.weigh = weigh;
        this.vertex = vertex;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weigh=" + weigh +
                ", vertex='" + vertex + '\'' +
                ", prev=" + prev +
                '}';
    }
}

public class Dijkstra {
    public int run(Map<String, List<Edge>> graph, String start) {
        Queue<Edge> queue = new PriorityQueue<>();
        Map<String, Edge> totalWeigh = new HashMap<>();

        for (String key: graph.keySet()) {
            totalWeigh.put(key, new Edge(Integer.MAX_VALUE, key));
        }

        totalWeigh.put(start, new Edge(0, start));
        queue.add(new Edge(0, start));

        while (!queue.isEmpty()) {
            Edge pollEdge = queue.poll();
            List<Edge> edgeList = graph.get(pollEdge.vertex);
            for (Edge edge: edgeList) {
                if (totalWeigh.get(edge.vertex).weigh > edge.weigh + pollEdge.weigh) {
                    totalWeigh.put(edge.vertex, new Edge(edge.weigh + pollEdge.weigh, edge.vertex, pollEdge));
                    queue.add(new Edge(edge.weigh + pollEdge.weigh, edge.vertex, pollEdge));
                }
            }
        }
        return 0;
    }
}
