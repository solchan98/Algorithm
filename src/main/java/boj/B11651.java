package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11651 {

    static int N;
    static Node[] nodes;

    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void println() {
            System.out.println(x + " " + y);
        }

        @Override
        public int compareTo(Node o) {
            if(this.y > o.y) return 1;
            else if(this.y == o.y && this.x > o.x) return 1;
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(nodes);
        Arrays.stream(nodes).forEach(Node::println);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        for (int idx = 0; idx < N; idx++) {
            String[] xy = br.readLine().split(" ");
            nodes[idx] = new Node(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
        }
    }
}
