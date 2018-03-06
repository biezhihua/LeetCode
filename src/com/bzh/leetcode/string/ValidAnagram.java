package com.bzh.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class ValidAnagram {

    @Test
    public void test() {
        Assert.assertEquals(true,isAnagram("anagram", "nagaram"));
        Assert.assertEquals(false,isAnagram("rat", "car"));
        Assert.assertEquals(true,isAnagram("biezhihua", "biezhihua"));
        Assert.assertEquals(false,isAnagram("biezhihua1", "biezhihua2"));
    }

    public boolean isAnagram(String s, String t) {

        char[] hash1 = new char[128];
        char[] hash2 = new char[128];

        for (int i = 0; i < s.length(); i++) {
            hash1[s.charAt(i)] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            hash2[t.charAt(i)] += 1;
        }

        for (int i = 0; i < 128; i++) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }

        return true;
    }
}
