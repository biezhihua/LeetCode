package com.bzh.leetcode.link;

import org.junit.Test;

import java.util.List;

public class DeleteNodeInALinkedList {

    @Test
    public void test() {

    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        ListNode next = node.next;

        node.next = next.next;
        node.val = next.val;

    }

     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
