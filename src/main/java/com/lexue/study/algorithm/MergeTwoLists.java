package com.lexue.study.algorithm;

import jdk.nashorn.internal.objects.NativeNumber;

import java.util.LinkedList;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists {



    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node6 = new Node(6);
        node1.next = node4;
        node4.next = node5;
        node2.next = node3;
        node3.next = node6;
        Node node = merge(node1, node2);
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    private static Node merge(Node node1, Node node2) {
        Node node = new Node();
        Node next = node;
        while (node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                next.next = node1;
                node1 = node1.next;
            } else {
                next.next = node2;
                node2 = node2.next;
            }
            next = next.next;
        }
        next.next = node1 != null ? node1 : node2;
        return node.next;

    }

    private static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }



}
