package com.lexue.study.algorithm;

/**
 * 单链表查询倒数第n个元素
 */
public class FindKelem {

    public static Node findNode(Node head, int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        while (temp != null) {
            temp = temp.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        nodeF.next = nodeG;
        System.out.println(findNode(nodeA, 3).value);
    }


    private static class Node {
        public String value;
        public Node next;

        public Node(String value) {
            this.value = value;
        }

        public Node() {
        }
    }
}
