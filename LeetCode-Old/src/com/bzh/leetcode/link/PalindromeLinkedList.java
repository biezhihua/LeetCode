package com.bzh.leetcode.link;

import org.junit.Test;

import java.util.Stack;

public class PalindromeLinkedList {

    @Test
    public void test(){

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }


        Stack<Integer> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;

        stack.push(head.val);

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }

        while (slow.next != null) {
            slow = slow.next;
            Integer tmp = stack.pop();
            if (tmp != slow.val) {
                return false;
            }
        }

        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
