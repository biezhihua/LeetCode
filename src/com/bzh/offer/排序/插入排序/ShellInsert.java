package com.bzh.offer.排序.插入排序;

import java.util.Arrays;

/**
 * https://zh.wikipedia.org/wiki/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F
 * <p>
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。希尔排序是非稳定排序算法。
 * <p>
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
 */
public class ShellInsert {

    public static void shellInsert(int a[]) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < a.length; i++) {
                int key = a[i];
                int j = i - gap;
                while (j >= 0 && a[j] > key) {
                    a[j + gap] = a[j];
                    j -= gap;
                }
                a[j + gap] = key;
            }
        }
    }

    public static void shell_sort(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        for (; gap > 0; gap /= 3)
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 9, 11, 6, 99, 22, 55};
        shellInsert(a);
        System.out.println(Arrays.toString(a));
    }
}
