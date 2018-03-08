package com.bzh.offer.剑指.树;

/**
 * Created by biezhihua on 16-8-19.
 */
public class 重建二叉树 {

    private static class Node {
        Node left;
        Node right;
        char value;
    }

    static Node rebuild(String preOrder, String inOrder) {

        if (preOrder == null || inOrder == null) {
            return null;
        }

        if (preOrder.length() == 0 || inOrder.length() == 0) {
            return null;
        }

        if (preOrder.length() != inOrder.length()) {
            return null;
        }

        Node root = new Node();
        root.value = preOrder.charAt(0);
        root.left = null;
        root.right = null;

        int preRootIndex = preOrder.indexOf(root.value);
        int inRootIndex = inOrder.indexOf(root.value);

        String leftInOrder = inOrder.substring(0, inRootIndex);
        String rightInOrder = inOrder.substring(inRootIndex + 1, inOrder.length());

        int leftLen = leftInOrder.length();

        String leftPreOrder = preOrder.substring(preRootIndex + 1, preRootIndex + 1 + leftLen);
        String rightPreOrder = preOrder.substring(preRootIndex + 1 + leftLen, preOrder.length());

        if (leftPreOrder.length() > 0 && leftInOrder.length() > 0) {
            root.left = rebuild(leftPreOrder, leftInOrder);
        }
        if (rightPreOrder.length() > 0 && rightInOrder.length() > 0) {
            root.right = rebuild(rightPreOrder, rightInOrder);
        }

        return root;
    }


    public static void main(String[] args) {
        String pre = "abdcef";
        String in = "dbaecf";
        Node rebuild = rebuild(pre, in);
        System.out.println(rebuild);
        printNodeByLevel(rebuild);
    }

    static int printNodeAtLevel(Node root, int level) {
        if (root == null || level < 0) {
            return 0;
        }
        if (level == 0) {
            System.out.printf(" " + root.value + " ");
            return 1;
        }

        return (printNodeAtLevel(root.left, level - 1) + printNodeAtLevel(root.right, level - 1));

    }

    static void printNodeByLevel(Node root) {
        for (int i = 0; ; i++) {
            if (printNodeAtLevel(root, i) == 0) {
                break;
            }
            System.out.println();
        }
    }
}
