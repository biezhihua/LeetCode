package com.bzh.leetcode.link;

import org.junit.Test;

public class RemoveNthNodeFromeEndOfList {

    @Test
    public void test() {
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
