package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class B1991 {

    static Node root;

    static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < cnt; idx++) {
            String[] strings = br.readLine().split(" ");
            createNode(strings[0], strings[1], strings[2]);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    private static void createNode(String data, String leftData, String rightData) {
        if (Objects.isNull(root)) {
            root = new Node(data);
            if (!leftData.equals(".")) root.left = new Node(leftData);
            if (!rightData.equals(".")) root.right = new Node(rightData);
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    private static void searchNode(Node node, String data, String leftData, String rightData) {
        if (!Objects.isNull(node)) {
            if(node.data.equals(data)) {
                if (!leftData.equals(".")) node.left = new Node(leftData);
                if (!rightData.equals(".")) node.right = new Node(rightData);
            } else {
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }
    }

    private static void preOrder(Node node) {
        if (!Objects.isNull(node)) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static void inOrder(Node node) {
        if (!Objects.isNull(node)) {
            if (!Objects.isNull(node.left)) {
                inOrder(node.left);
            }
            System.out.print(node.data);
            if (!Objects.isNull(node.right)) {
                inOrder(node.right);
            }
        }
    }

    private static void postOrder(Node node) {
        if (!Objects.isNull(node)) {
            if (!Objects.isNull(node.left)) {
                postOrder(node.left);
            }
            if (!Objects.isNull(node.right)) {
                postOrder(node.right);
            }
        }
        System.out.print(node.data);
    }
}
