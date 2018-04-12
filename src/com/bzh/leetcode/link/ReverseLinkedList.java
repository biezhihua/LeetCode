package com.bzh.leetcode.link;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;

        // 不断取出和向后移动头节点
        // 并将头节点连接到新头节点后面
        while (head != null) {

            // 单独取出下一个节点
            ListNode next = head.next;

            // 将头节点连接到新头节点后面
            head.next = newHead;
            newHead = head;

            // 向后移动头节点
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
