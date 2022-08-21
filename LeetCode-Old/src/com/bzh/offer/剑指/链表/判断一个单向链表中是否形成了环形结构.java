package com.bzh.offer.剑指.链表;

/**
 * Created by biezhihua on 16-8-25.
 */
public class 判断一个单向链表中是否形成了环形结构 {

    /**
     * 题目:
     * 判断一个单向链表是否形成了环形结构.
     * <p>
     * 思路:
     * 定义两个指针,同时从链表头部出发,一个指针一次走一步,另一个指针一次走两步.如果走的快的指针追上了走的慢的指针,那么链表就是环形链表.
     * 如果走的快的的走到了链表尾部都没追上第一个指针,那么链表就不是环形链表.
     */
    private static class Node {
        int value;
        Node next;
    }

    static boolean isRing(Node head) {
        if (head == null) {
            return false;
        }

        Node pre = head;
        Node rear = head;

        while (rear.next != null) {

            if (rear.next.next != null) {
                rear = rear.next.next;
            } else {
                return false;
            }

            if (rear.next.next == pre) {
                return true;
            }

            pre = pre.next;
        }

        return false;
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
        Node _9 = addTail(head, 9);
        addTail(head, 10);
        addTail(head, 11);
        addTail(head, 12);
        addTail(head, 13);
        addTail(head, 14);
        Node tail = addTail(head, 15);
        tail.next = _9;

        System.out.println(isRing(head));
    }

    private static Node addTail(Node head, int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
        return node;
    }
}