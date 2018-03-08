package com.bzh.offer.排序.插入排序;

import java.util.Arrays;

/**
 * https://zh.wikipedia.org/wiki/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F
 */
public class InsertSort {

//    从第一个元素开始，该元素可以认为已经被排序
//    取出下一个元素，在已经排序的元素序列中从后向前扫描
//    如果该元素（已排序）大于新元素，将该元素移到下一位置
//    重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
//            将新元素插入到该位置后
//    重复步骤2~5
    public static void insertSort(int a[]) {

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 9, 11, 6, 99, 22, 55};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
