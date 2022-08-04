package leetcode;

class Node {
    private final int value;
    private Node prevNode;
    private Node nextNode;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Node getPrevNode() {
        return this.prevNode;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class CustomLinkedList {
    private Node head;
    private int size;

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void addNode(Node node) {
        Node curNode = this.head;
        if (this.size == 0) {
            this.head = node;
        } else {
            while (curNode.getNextNode().getValue() != this.head.getValue()) curNode = curNode.getNextNode();
            node.setPrevNode(curNode);
            curNode.setNextNode(node);
        }
        node.setNextNode(this.head);
        this.head.setPrevNode(node);
        this.size += 1;
    }

    public void deleteByValue(int val) {
        if (this.head.getNextNode() == null && this.head.getValue() == val) {
            this.head = null;
        } else if (this.head.getValue() == val) {
            this.head.getPrevNode().setNextNode(this.head.getNextNode());
            this.head.getNextNode().setPrevNode(this.head.getPrevNode());
            this.head = this.head.getNextNode();
        } else {
            Node curNode = this.head;
            while (curNode.getValue() != val) {
                curNode = curNode.getNextNode();
                if (curNode.getValue() == this.head.getValue()) return;
            }
            curNode.getPrevNode().setNextNode(curNode.getNextNode());
            curNode.getNextNode().setPrevNode(curNode.getPrevNode());
        }
        this.size -= 1;
    }
}

/** find the winner of the circular game */
public class Leet1823 {
    public int findTheWinner(int n, int k) {
        CustomLinkedList list = new CustomLinkedList();

        for (int i = 1; i <=n; i++) {
            list.addNode(new Node(i));
        }

        Node cur = list.getHead();
        while (list.getSize() != 1) {
            for (int j = 0; j < k - 1; j++) {
                cur = cur.getNextNode();
            }
            int willDeleteValue = cur.getValue();
            cur = cur.getNextNode();
            list.deleteByValue(willDeleteValue);
        }
        return list.getHead().getValue();
    }
}
