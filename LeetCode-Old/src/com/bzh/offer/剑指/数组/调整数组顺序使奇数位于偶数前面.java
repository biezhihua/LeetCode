package com.bzh.offer.剑指.数组;

import java.util.Arrays;

/**
 * Created by biezhihua on 16-8-25.
 */
public class 调整数组顺序使奇数位于偶数前面 {

    /**
     * 题目:输入一个整数数组,实现一个函数来调整该数组中数组的顺序,
     * 使得所有奇数位于数组的前半部分,所有偶数位于奇数的后面.
     * <p>
     * 思路:
     * 定义最左侧一个索引low,定义最右侧索引height.
     * low必须小于height,然后,从数组最左侧开始向右搜索偶数,从数组最右侧开始向左搜索奇数
     * 如果遇到则交换位置.
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        method(a);

        System.out.println(Arrays.toString(a));

        method1(b, new Rule<Integer>() {
            @Override
            public boolean rule(Integer integer) {
                return (integer & 0x1) == 0;
            }
        });
        System.out.println(Arrays.toString(b));
    }

    private static void method(int[] a) {

        if (a == null || a.length == 0) {
            return;
        }

        int low = 0;
        int height = a.length - 1;

        while (low < height) {
            while (low < height && (a[low] & 0x1) != 0) {
                low++;
            }
            while (low < height && (a[height] & 0x1) == 0) {
                height--;
            }

            if (low < height) {
                int temp = a[low];
                a[low] = a[height];
                a[height] = temp;
            }
        }
    }

    private static void method1(int[] a, Rule<Integer> rule) {

        if (a == null || a.length == 0) {
            return;
        }

        int low = 0;
        int height = a.length - 1;

        while (low < height) {
            while (low < height && !rule.rule(a[low])) {
                low++;
            }
            while (low < height && rule.rule(a[height])) {
                height--;
            }

            if (low < height) {
                int temp = a[low];
                a[low] = a[height];
                a[height] = temp;
            }
        }
    }

    interface Rule<T> {
        boolean rule(T t);
    }
}
