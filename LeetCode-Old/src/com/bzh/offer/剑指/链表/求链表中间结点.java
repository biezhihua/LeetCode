package com.bzh.offer.剑指.链表;

/**
 * Created by biezhihua on 16-8-25.
 */
public class 求链表中间结点 {

    /**
     * 题目:
     * 求链表中间结点.如果链表中结点总数为奇数,则返回中间结点.如果链表中结点总数为偶数,则返回中间两个结点任意一个.
     * <p>
     * 思路:
     * 为了解决这个问题,可以定义两个指针,同时从链表的头结点出发,一个指针一次走一步,另一个指针一次都两步.
     * 当走的快的走到链表末尾时,走的慢的正好在链表中间.
     */

    private static class Node {
        int value;
        Node next;
    }

    private static Node findMidNode(Node head) {
        if (head == null) {
            return null;
        }

        Node pre = head;
        Node rear = head;

        while (rear.next != null) {
            if (rear.next.next != null) {
                rear = rear.next.next;
            } else {
                return pre;
            }
            pre = pre.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.value = 1;
        addTail(head, 2);
        addTail(head, 3);
        addTail(head, 4);
        addTail(head, 5);
        addTail(head, 6);
        addTail(head, 7);
        addTail(head, 8);
        addTail(head, 9);
        addTail(head, 10);
        addTail(head, 11);

        System.out.println(findMidNode(head).value);
    }

    private static void addTail(Node head, int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
}
