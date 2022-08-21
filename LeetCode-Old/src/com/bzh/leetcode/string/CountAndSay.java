package com.bzh.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class CountAndSay {

        @Test
        public void test() {
            Assert.assertEquals("1", countAndSay(1));
            Assert.assertEquals("11", countAndSay(2));
            Assert.assertEquals("21", countAndSay(3));
            Assert.assertEquals("1211", countAndSay(4));
            Assert.assertEquals("111221", countAndSay(5));
            Assert.assertEquals("312211", countAndSay(6));
            Assert.assertEquals("13112221", countAndSay(7));
            Assert.assertEquals("1113213211", countAndSay(8));
            Assert.assertEquals("31131211131221", countAndSay(9));
            Assert.assertEquals("13211311123113112211", countAndSay(10));
        }

        public String countAndSay(int n) {

            if (n <= 0) return "-1";

            String result = "1";
            for (int i = 1; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                int index = 0;
                while (index < result.length()) {
                    // 记录值
                    char val = result.charAt(index);
                    // 记录连续位数
                    int count = 0;

                    // 查找连续位数，碰到不相同的数字时停止。
                    while (index < result.length() && result.charAt(index) == val) {
                        index++;
                        count++;
                    }

                    // 追加连续位数到结果中
                    builder.append(String.valueOf(count));
                    // 追加连续位数的值到结果中
                    builder.append(val);
                }
                result = builder.toString();
            }
            return result;
        }

}
