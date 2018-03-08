package com.bzh.offer.排序.交换排序;

import java.util.Arrays;


/**
 * https://zh.wikipedia.org/wiki/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F
 */
public class BubbleSort {

    public static void bubbleSort(int a[]) {

        boolean change = true;
        for (int i = 1; i <= a.length - 1 && change; i++) {
            change = false;
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    change = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 2, 5, 8, 6, 88, 11, 55, 22, 33, 99, 76};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
