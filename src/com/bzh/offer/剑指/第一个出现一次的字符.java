package com.bzh.offer.剑指;

/**
 * Created by biezhihua on 16-8-26.
 */
public class 第一个出现一次的字符 {

    /**
     * 题目:
     * 在字符串中找出第一个只出现一次的字符.
     * 如输入abaccdeff,则输出b
     *
     * 思路:
     * 可以定义哈希表的Key是字符,Value是该字符出现的次数.
     * 这样需要扫描字符串两次,第一次扫描,每扫描到一个字符就在哈希表的对应项次数加1.
     * 接下来第二次扫描时,每扫描一个字符就能获取到该字符出现的次数.
     *
     * 本题比较特殊,简单的哈希表就能满足需求.字符char是一个长8位的数据类型,共有256中可能.
     * 于是创建一个256的数组,每个字符的ASCII码值作为数组的下标,其值对应字符次数.
     * 这样就创建了一个256大小,以字符ASCII码作为键值的哈希表.
     */

    public static void main(String[] args) {

        String str = "abaccdeff";

        System.out.println(firstNotRepeatingChar(str));
    }

    private static char firstNotRepeatingChar(String str) {

        char[] hasTable = new char[1<<8];

        for (int i = 0; i < str.length(); i++) {
            hasTable[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (hasTable[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return 0;
    }
}
