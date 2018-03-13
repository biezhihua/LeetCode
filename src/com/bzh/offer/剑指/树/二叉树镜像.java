package com.bzh.offer.剑指.树;

/**
 * Created by biezhihua on 16-8-25.
 */
public class 二叉树镜像 {

    /**
     * 题目:
     * 请完成一个函数,输入一个二叉树,该函数输出他的的镜像.
     * <p>
     * 思路:
     * 先序遍历这棵树的每个结点,如果遍历到结点有子结点,就交换它的两个子结点,
     * 当交换完所有非叶子结点的左右结点之后,就的到了树的镜像.
     */

    static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    private static void mirrorRecursively(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null) {
            return;
        }

        BinaryTreeNode temp = head.left;
        head.left = head.right;
        head.right = temp;

        if (head.left != null) {
            mirrorRecursively(head.left);
        }

        if (head.right != null) {
            mirrorRecursively(head.right);
        }
    }
}
