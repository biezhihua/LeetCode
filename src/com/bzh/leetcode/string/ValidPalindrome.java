package com.bzh.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindrome {
    @Test
    public void test() {

        Assert.assertEquals(true, isPalindrome(""));
        Assert.assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertEquals(true, isPalindrome("1A man, a plan, a canal: Panama1"));
        Assert.assertEquals(false, isPalindrome("race a car"));
        Assert.assertEquals(false, isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex < endIndex && startIndex < s.length() - 1) {
            char pre = s.charAt(startIndex);
            char aft = s.charAt(endIndex);
            if (!((pre >= 'a' && pre <= 'z') || (pre >= '0' && pre <= '9'))) {
                startIndex++;
                continue;
            }
            if (!((aft >= 'a' && aft <= 'z') || (aft >= '0' && aft <=  '9'))) {
                endIndex--;
                continue;
            }

            if (pre != aft) {
                return false;
            }
            startIndex++;
            endIndex--;
        }

        return true;
    }
}
