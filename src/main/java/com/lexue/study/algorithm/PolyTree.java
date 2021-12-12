package com.lexue.study.algorithm;

import com.google.common.collect.Lists;
import com.lexue.study.spring.bean.A;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * 树的深度遍历和广度遍历
 */
public class PolyTree {

    /**
     * 广度优先
     */
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (CollectionUtils.isNotEmpty(queue)) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            List<Node> nodes = cur.nodes;
            if (CollectionUtils.isNotEmpty(nodes)) {
                nodes.forEach(queue::offer);
            }
        }
    }

    /**
     * 深度优先
     */
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.offer(node);
        while (CollectionUtils.isNotEmpty(stack)) {
            Node cur = stack.pollLast();
            System.out.print(cur.value + " ");
            List<Node> nodes = cur.nodes;
            if (CollectionUtils.isNotEmpty(nodes)) {
                Collections.reverse(nodes);
                nodes.forEach(stack::offer);
            }
        }
    }


    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        nodeA.nodes = Lists.newArrayList(nodeB, nodeC);
        nodeB.nodes = Lists.newArrayList(nodeD, nodeE);
        nodeE.nodes = Lists.newArrayList(nodeI);
        nodeC.nodes = Lists.newArrayList(nodeF, nodeG, nodeH);
        dfs(nodeA);
        System.out.println();
        bfs(nodeA);
    }


    private static class Node {
        public String value;

        public List<Node> nodes;

        public Node(String value) {
            this.value = value;
        }
    }

}
