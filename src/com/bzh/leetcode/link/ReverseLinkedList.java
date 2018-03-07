package com.bzh.leetcode.link;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);

        dummyNode.next = head;
        ListNode cur = head;

        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = dummyNode.next;
            dummyNode.next = tmp;
        }

        return dummyNode.next;
    }
}
