package com.bzh.offer.剑指.数组;

/**
 * Created by biezhihua on 16-8-16.
 */
public class 求数组的字数组之和最大值 {

    public static void main(String[] args) {
        int[] a = {-2, 5, 3, -6, 4, -8, 6};


        method2(a);
    }

    private static void method2(int[] a) {
        int nStart = a[a.length - 1];
        int nAll = a[a.length - 1];

        for (int i = a.length - 2; i >= 0; i--) {
            nStart = Integer.max(a[i], a[i] + nStart);
            nAll = Integer.max(nStart, nAll);
        }

        System.out.println(nAll);
    }

    private static void method1(int[] a) {
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum > maximum) {
                    maximum = sum;
                }
            }
        }

        System.out.println(maximum);
    }
}
