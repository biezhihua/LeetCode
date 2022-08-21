package com.bzh.offer.问题;

/**
 * Created by biezhihua on 16-8-19.
 */
public class 求二叉树中结点的最大值 {

    private int maxLen;

    static class Node {

        public Node left;
        public Node right;
        public Node value;
        public int maxLeft;
        public int maxRight;
    }

    public void finMax(Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null) {
            root.maxLeft = 0;
        }

        if (root.right == null) {
            root.maxRight = 0;
        }

        if (root.left != null) {
            finMax(root.left);
        }

        if (root.right != null) {
            finMax(root.right);
        }

        if (root.left != null) {
            int maxTemp;
            if (root.left.maxLeft > root.left.maxRight) {
                maxTemp = root.left.maxLeft;
            } else {
                maxTemp = root.left.maxRight;
            }
            root.maxLeft = maxTemp + 1;
        }

        if (root.right != null) {
            int maxTemp;
            if (root.right.maxLeft > root.right.maxRight) {
                maxTemp = root.right.maxLeft;
            } else {
                maxTemp = root.right.maxRight;
            }
            root.maxRight = maxTemp + 1;
        }

        if (root.maxLeft + root.maxRight > maxLen) {
            maxLen = root.maxLeft + root.maxRight;
        }
    }

    public static void main(String[] args) {

    }

}
