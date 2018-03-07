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
            // 因为都是用int型的，如果超出了范围，其除以10的结果就不会跟之前的结果一致，通过这点也可以进行区分

            int tmp = result * 10 + x % 10;

            if (tmp / 10 != result) {
                return 0;
            }

            result = tmp;

            x = x / 10;
        }

        return result;
    }

}
