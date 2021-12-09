package com.lexue.study.algorithm;

import lombok.Data;

import java.util.Objects;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class BinaryTree {

    public static void preOrder(TreeNode treeNode) { //根左右
        if (Objects.isNull(treeNode)) {
            return;
        }
        System.out.print(treeNode.getValue() + " ");
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }

    public static void preOder1(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.getValue() + " ");
            if (Objects.nonNull(node.getRight())) {
                stack.push(node.getRight());
            }
            if (Objects.nonNull(node.getLeft())) {
                stack.push(node.getLeft());
            }
        }
    }

    public static void midOrder(TreeNode treeNode) { //左根右
        if (Objects.isNull(treeNode)) {
            return;
        }
        midOrder(treeNode.getLeft());
        System.out.print(treeNode.getValue() + " ");
        midOrder(treeNode.getRight());
    }

    public static void midOrder1(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || Objects.nonNull(treeNode)) {
            while (Objects.nonNull(treeNode)) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }
            TreeNode node = stack.pop();
            System.out.print(node.getValue() + " ");
            if (Objects.nonNull(node.getRight())) {
                treeNode = node.getRight();
            }
        }
    }

    public static void postOrder(TreeNode treeNode) { //左右根
        if (Objects.isNull(treeNode)) {
            return;
        }
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.print(treeNode.getValue() + " ");
    }

    public static void postOrder1(TreeNode treeNode) {//左右根
        if (Objects.isNull(treeNode)) {
            return;
        }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode pre = treeNode;
//        while (!stack.isEmpty() || Objects.nonNull(treeNode)) {
//            while (Objects.nonNull(treeNode)) {
//                stack.push(treeNode);
//                treeNode = treeNode.getLeft();
//            }
//
//            treeNode = stack.peek().getRight();
//            if (Objects.isNull(treeNode) || treeNode.equals(pre)) {
//                treeNode = stack.pop();
//                System.out.print(treeNode.getValue() + " ");
//                pre = treeNode;
//                treeNode = null;
//            }
//        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(treeNode);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (Objects.nonNull(node.getLeft())) {
                stack1.push(node.getLeft());
            }
            if (Objects.nonNull(node.getRight())) {
                stack1.push(node.getRight());
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getValue() + " ");
        }
    }


    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeE.left = nodeG;
        nodeC.right = nodeF;
        preOrder(nodeA);
        System.out.println();
        preOder1(nodeA);
        System.out.println();
        midOrder(nodeA);
        System.out.println();
        midOrder1(nodeA);
        System.out.println();
        postOrder(nodeA);
        System.out.println();
        postOrder1(nodeA);
    }


    @Data
    public static class TreeNode {
        private String value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(String value) {
            this.value = value;
        }
    }
}
