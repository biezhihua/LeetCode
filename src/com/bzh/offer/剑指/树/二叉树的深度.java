package com.bzh.offer.剑指.树;

/**
 * Created by biezhihua on 16-8-28.
 */
public class 二叉树的深度 {

    /**
     * 题目:
     * 输入一个二叉树的根节点,求该树的深度.
     */

    static class Node {
        int value;
        Node left;
        Node right;
    }

    static int treeDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }

    /**
     * 题目:
     * 输入一棵二叉树的根节点,判断该树是不是平衡二叉树.
     * 如果某二叉树的任意结点的左右子树深度相差不超过1,那么它就是一个平衡二叉树.
     */

}
