package com.bzh.offer.剑指.链表;

import java.util.LinkedList;

public class 从尾到头打印链表 {

    private static class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.value = 1;
        addTail(head, 2);
        addTail(head, 3);
        addTail(head, 4);
        addTail(head, 5);

        method1(head);
        System.out.println();
        method2(head);
    }

    private static void method1(Node head) {
        LinkedList<Integer> nodes = new LinkedList<>();

        while (head != null) {
            nodes.push(head.value);
            head = head.next;
        }

        while (!nodes.isEmpty()) {
            System.out.print(nodes.pop() + " ");
        }
    }

    private static void method2(Node head) {
        if (head != null) {
            method2(head.next);
            System.out.printf(head.value + " ");
        }
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
