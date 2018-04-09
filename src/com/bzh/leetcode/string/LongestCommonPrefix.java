package com.bzh.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonPrefix {

    @Test
    public void test() {
        Assert.assertEquals("leet", longestCommonPrefix(new String[]{"leets", "leetcode", "leet", "leets"}));
    }

    // Horizontal Scanning
    public String longestCommonPrefix_horizontal(String[] strs) {

        if (strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            // 找出S1与Si间的最长公共字符串
            // indexOf：当存在串时返回>0；不存串时返回-1
            // 只要不存在串，就缩减串的规模，再进行查找
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            // 获得第一行i列的字符
            char c = strs[0].charAt(i);

            // 依次比较剩余行相同列的字符
            for (int j = 1; j < strs.length; j++) {

                // 若j行i列的字符与第一行i列的字符不同，代表最长公共前缀判定结束
                // 若第一行新i列已经超出了剩余行的最大列出，也代表最长公共前缀判定结束
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
