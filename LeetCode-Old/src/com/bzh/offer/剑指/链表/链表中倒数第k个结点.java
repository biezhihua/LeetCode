package com.bzh.offer.剑指.链表;

/**
 * Created by biezhihua on 16-8-25.
 */
public class 链表中倒数第k个结点 {

    /**
     * 题目:
     * 输入一个链表,输出该链表倒数第K个结点.
     * 为了符合大多数人的习惯,本题从1开始计数,即尾结点是倒数第1个结点.
     * 例如一个链表有6个结点,从头结点开始他们的值依次是1,2,3,4,5,6.
     * 这个链表的倒数第3个结点的值为4的结点.
     *
     * 思路:
     * 为了实现只遍历一次就能找到第K个结点,可以定义两个指针.
     * 第一个指针从链表的头指针开始遍历向前走K-1,第二个指针保持不动;
     * 从第k步开始,第二个指针也开始从链表的头指针开始遍历.
     * 由于两个指针的距离保持在k-1,当第一个指针到达尾结点时,第二个指针正好是倒数第k个结点.
     *
     *
     * 易错点:
     *
     * 1. k <= 0
     * 2. 第一个指针先走过程中碰到null
     */

     
    private static class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) {

    }

    static Node findKthToTail(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        Node pre = head;
        Node rear = head;
        for (int i = 0; i < k - 1; i++) {
            if (rear.next != null) {
                rear = rear.next;
            } else {
                return null;
            }
        }

        while (rear.next != null) {
            pre = pre.next;
            rear = rear.next;
        }

        return pre;
    }
}
