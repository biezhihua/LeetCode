package com.bzh.offer.排序.选择排序;

import java.util.Arrays;

/**
 * https://zh.wikipedia.org/wiki/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F
 * 选择排序（Selection sort）是一种简单直观的排序算法。它的工作原理如下。
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectSort {

    public static void selectSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[k] > a[j]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 9, 11, 6, 99, 22, 55};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
