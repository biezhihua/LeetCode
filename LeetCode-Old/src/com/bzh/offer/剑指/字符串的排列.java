package com.bzh.offer.剑指;

import java.util.Arrays;

/**
 * Created by biezhihua on 16-8-26.
 */
public class 字符串的排列 {


    /**
     * 题目:
     * 输入一个字符串,打印出该字符串中字符的所有排列.
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,nca,cab,cba.
     * <p>
     * 思路:
     * 首先求出所有可能出现在第一个位置的字符,即把第一个字符和后面的字符交换.
     * 第二步固定第一个字符串,求后面所有字符的排列.
     * 这个时候扔把后面的所有字符分成两部分:后面字符的第一个字符,以及这个字符之后的所有字符.
     * 然后把第一个字符逐一和它后面的字符交换.
     */


    public static void main(String[] args) {
        String str = "abc";
        print(str);
    }

    private static void print(String str) {
        print(str.toCharArray(), 0);
    }

    private static void print(char[] str, int starIndex) {

        if (starIndex == str.length - 1) {
            System.out.println(Arrays.toString(str));
            return;
        }

        for (int i = starIndex; i < str.length; i++) {

            char tmp = str[i];
            str[i] = str[starIndex];
            str[starIndex] = tmp;

            print(str, starIndex + 1);

            tmp = str[i];
            str[i] = str[starIndex];
            str[starIndex] = tmp;
        }
    }
}
