package com.bzh.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class ReverseInteger {

    @Test
    public void test1() {
        Assert.assertEquals(321, reverse(123));
        Assert.assertEquals(654321, reverse(123456));
        Assert.assertEquals(-654321, reverse(-123456));
        Assert.assertEquals(0, reverse(214748364));
        Assert.assertEquals(63847412, reverse(21474836));
        Assert.assertEquals(73847412, reverse(21474837));
    }

    public int reverse(int x) {

        int result = 0;
        while (x != 0) {

            if (Math.abs(result) > 214748364 / 10) return 0;

            result = result * 10 + x % 10;

            x = x / 10;
        }

        return result;
    }

}
