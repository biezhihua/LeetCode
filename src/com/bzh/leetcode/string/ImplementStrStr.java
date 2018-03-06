package com.bzh.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class ImplementStrStr {

    @Test
    public void test() {
        Assert.assertEquals(0, strStr("", ""));
        Assert.assertEquals(-1, strStr("", "a"));
        Assert.assertEquals(0, strStr("a", "a"));
        Assert.assertEquals(-1, strStr("aaaa", "bba"));
        Assert.assertEquals(-1, strStr("aaa", "aaaa"));
        Assert.assertEquals(2, strStr("hello", "ll"));
        Assert.assertEquals(4, strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.isEmpty()) {
            return -1;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(j + i) != needle.charAt(j)) {
                    break;
                }

                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
