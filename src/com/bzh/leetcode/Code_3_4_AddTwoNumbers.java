package com.bzh.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcodechina.com/problems/add-two-numbers/description/
 */
public class Code_3_4_AddTwoNumbers {

    @Test
    public void test() {
        ListNode _342 = new ListNode(2);
        _342.next = new ListNode(4);
        _342.next.next = new ListNode(3);

        ListNode _465 = new ListNode(5);
        _465.next = new ListNode(6);
        _465.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(_342, _465);
        Assert.assertEquals(7, result.val);
        Assert.assertEquals(0, result.next.val);
        Assert.assertEquals(8, result.next.next.val);


        ListNode result1 = addTwoNumbers(new ListNode(5), new ListNode(5));
        Assert.assertEquals(0, result1.val);
        Assert.assertEquals(1, result1.next.val);


        ListNode _98 = new ListNode(9);
        _98.next = new ListNode(8);

        ListNode _1 = new ListNode(1);
        ListNode result2 = addTwoNumbers(_98, _1);
        Assert.assertEquals(0, result2.val);
        Assert.assertEquals(9, result2.next.val);
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = null;
        ListNode result = null;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            if (tmp == null) {
                tmp = node;
                result = tmp;
            } else {
                tmp.next = node;
                tmp = tmp.next;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
