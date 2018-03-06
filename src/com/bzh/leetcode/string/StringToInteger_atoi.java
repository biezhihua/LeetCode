package com.bzh.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class StringToInteger_atoi {

    @Test
    public void test() {

        Assert.assertEquals(1, myAtoi("1"));
        Assert.assertEquals(1, myAtoi("+1"));
        Assert.assertEquals(0, myAtoi("+-1"));
        Assert.assertEquals(1, myAtoi("00001"));
        Assert.assertEquals(1, myAtoi("     1"));
        Assert.assertEquals(-1, myAtoi("-00001"));
        Assert.assertEquals(0, myAtoi(""));
        Assert.assertEquals(123, myAtoi("123"));
        Assert.assertEquals(-123, myAtoi("-123"));
        Assert.assertEquals(2147483647, myAtoi("2147483647"));
        Assert.assertEquals(2147483647, myAtoi("+2147483647"));
        Assert.assertEquals(2147483647, myAtoi("2147483648"));
        Assert.assertEquals(-12, myAtoi("  -0012a42"));
        Assert.assertEquals(0, myAtoi("   +0 123"));

    }

    public int myAtoi(String str) {

        if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0, n = str.length();

        while (i < n && str.charAt(i) == ' ') ++i;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }

        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }
}
