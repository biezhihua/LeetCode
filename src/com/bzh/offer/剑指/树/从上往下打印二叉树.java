package com.bzh.offer.剑指.树;

import java.util.LinkedList;

public class 从上往下打印二叉树 {

    /**
     * 题目:
     * <p>
     * 从上往下打印二叉树的每个结点,同一层的结点按照从左到右的顺序打印.
     * <p>
     * 8
     * |  \
     * 6  10
     * | \  | \
     * 5  7  9 11
     * <p>
     * 思路:
     * 每一次打印一个结点的时候,如果该结点有子结点,则把该结点的子节点放到一个队列的末尾.
     * 接下再来到队列的头部取出最早进入队列的结点,重复前面的打印操作,直至队列中所有的结点都被打印出来为止.
     */

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);

        Node _6 = new Node(6);
        Node _10 = new Node(10);
        root.left = _6;
        root.right = _10;

        Node _5 = new Node(5);
        Node _7 = new Node(7);
        _6.left = _5;
        _6.right = _7;

        Node _9 = new Node(9);
        Node _11 = new Node(11);
        _10.left = _9;
        _10.right = _11;

        print(root);

        printNodeByLevel(root);
    }

    static void print(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            Node node = queue.poll();

            System.out.printf(node.value + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    private static int printNodeAtLevel(Node node, int level) {
        if (node == null || level < 0) {
            return 0;
        }
        if (level == 0) {
            System.out.printf(node.value + " ");
            return 1;
        }

        return printNodeAtLevel(node.left, level - 1) + printNodeAtLevel(node.right, level - 1);
    }

    private static void printNodeByLevel(Node node) {
        if (node == null) {
            return;
        }

        for (int level = 0; ; level++) {
            if (printNodeAtLevel(node, level) == 0) {
                break;
            }
            System.out.println();
        }
    }
}
