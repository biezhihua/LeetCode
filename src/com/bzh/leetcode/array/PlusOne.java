package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));
        Assert.assertArrayEquals(new int[]{3}, plusOne(new int[]{2}));
        Assert.assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
        Assert.assertArrayEquals(new int[]{9, 1}, plusOne(new int[]{9, 0}));
        Assert.assertArrayEquals(new int[]{1, 0, 0}, plusOne(new int[]{9, 9}));
    }

    public int[] plusOne(int[] digits) {

        List<Integer> list = new ArrayList<>();

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + carry;
            carry = tmp / 10;
            list.add(tmp % 10);
        }

        if (carry != 0) {
            list.add(carry);
        }

        Collections.reverse(list);

        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1}, plusOne1(new int[]{0}));
        Assert.assertArrayEquals(new int[]{3}, plusOne1(new int[]{2}));
        Assert.assertArrayEquals(new int[]{1, 0}, plusOne1(new int[]{9}));
        Assert.assertArrayEquals(new int[]{9, 1}, plusOne1(new int[]{9, 0}));
        Assert.assertArrayEquals(new int[]{1, 0, 0}, plusOne1(new int[]{9, 9}));
    }

    public int[] plusOne1(int[] digits) {


        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            }
            int tmp = digits[i] + carry;
            carry = tmp / 10;
            digits[i] = tmp % 10;
        }

        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }
}
