package com.bzh.offer.剑指.数组;

import java.util.TreeMap;

/**
 * Created by biezhihua on 16-8-26.
 */
public class 最小的K个数 {

    /**
     * 题目:
     * 输入n个整数,找出其中最小的K个数.
     * 例如输入,2,7,3,8,4,5,1,6这8个数字,则最小的是1,2,3,4
     */

    public static void main(String[] args) {
        int[] a = {8, 7, 6, 5, 4, 3, 2, 2, 2, 2, 2, 2, 1};

        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (tree.size() < 4) {
                tree.put(i, a[i]);
            } else {
                tree.pollFirstEntry();
                tree.put(i, a[i]);
            }
        }
        System.out.println(tree);
    }
}
