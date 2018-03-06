package com.bzh.leetcode.link;

import org.junit.Test;

public class RemoveNthNodeFromeEndOfList {

    @Test
    public void test() {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//
//        ListNode listNode = removeNthFromEnd(head, 2);
//        System.out.println(listNode);

        ListNode head = new ListNode(1);
        ListNode listNode = removeNthFromEnd(head, 1);
        System.out.println(listNode);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode preNode = head;
        ListNode curNode = head;

        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }

        if (curNode == null) {
            return preNode.next;
        }

        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }

        preNode.next = preNode.next.next;

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
