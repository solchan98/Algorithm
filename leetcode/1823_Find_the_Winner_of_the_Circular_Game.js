class Node {
  constructor(
    value
  ) {
    this.value = value;
    this.prevNode = null;
    this.nextNode = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.size = 0;
  }

  addNode(node) {
    let curNode = this.head;
    if (this.size === 0) {
      this.head = node;
    } else {
      if (this.size > 1) {
        while (curNode.nextNode.value !== this.head.value) curNode = curNode.nextNode;
      }
      node.prevNode = curNode;
      curNode.nextNode = node;
    }
    node.nextNode = this.head;
    this.head.prevNode = node;
    this.size += 1;
  }

  deleteByValue(v) {
    if (this.head.nextNode === null && this.head.value === v) {
      this.head = null;
    } else if (this.head.value === v) {
      this.head.prevNode.nextNode = this.head.nextNode;
      this.head.nextNode.prevNode = this.head.prevNode;
      this.head = this.head.nextNode;
    } else {
      let curNode = this.head;
      while (curNode.value !== v) {
        curNode = curNode.nextNode;
        if (curNode.value === this.head.value) return;
      }
      curNode.prevNode.nextNode = curNode.nextNode;
      curNode.nextNode.prevNode = curNode.prevNode;
    }
    this.size -=1;
  }
}


const findTheWinner = function(n, k) {

  const list = new LinkedList();

  for (let i = 1; i <= n; i++) {
    list.addNode(new Node(i));
  }

  let cur = list.head;
  while (list.size !== 1) {
    for (let j = 0; j < k - 1; j++) {
      cur = cur.nextNode;
    }
    const willDeleteValue = cur.value;
    cur = cur.nextNode;
    list.deleteByValue(willDeleteValue);
  }
  return list.head.value;
};

const result = findTheWinner(10, 7);
console.log(result);

