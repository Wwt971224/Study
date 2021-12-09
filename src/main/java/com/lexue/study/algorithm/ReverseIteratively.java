package com.lexue.study.algorithm;

/**
 * 单链表反转
 */
public class ReverseIteratively {

    public static Node reverse(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
        Node reverse = reverse(nodeA);
        while (reverse != null) {
            System.out.print(reverse.value + " ");
            reverse = reverse.next;
        }
    }

    private static class Node {
        public String value;
        public Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}
