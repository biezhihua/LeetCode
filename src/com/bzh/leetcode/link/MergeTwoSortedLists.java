package com.bzh.leetcode.link;

import org.junit.Test;

import java.util.List;

public class MergeTwoSortedLists {

    @Test
    public void test() {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(5);

        ListNode result = mergeTwoLists(head1, head2);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);

        ListNode curNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        curNode.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
