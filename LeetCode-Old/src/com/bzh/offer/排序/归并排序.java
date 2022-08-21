package com.bzh.offer.排序;

import java.util.Arrays;

/**
 * https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F
 *
 * 基本思想：基于合并,将两个或两个以上有序表合并成一个新的有序表.
 * <p>
 * 假设初始序列含有n个记录,首先将这个n个记录看成n个有序子序列,每个序列的长度为1,然后两两归并,并得到n/2个长度为2的有序子序列.
 * 再对长度为2的有序子序列进行两两归并.
 * 如此重复,直到有序为止.
 */
public class 归并排序 {

    static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    static void mergeSort(int a[]) {
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    static void merge(int[] a, int[] tmpArray, int lefPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = lefPos;
        int numElements = rightEnd - lefPos + 1;

        while (lefPos <= leftEnd && rightPos <= rightEnd) {
            if (a[lefPos] <= a[rightPos]) {
                tmpArray[tmpPos++] = a[lefPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (lefPos <= leftEnd) {
            tmpArray[tmpPos++] = a[lefPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7, 10, 4, 6, 8, 13, 15};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    /***
     * 递归版本
     */
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {

        if (start >= end)
            return;

        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];

        while (start1 <= end1)
            result[k++] = arr[start1++];

        while (start2 <= end2)
            result[k++] = arr[start2++];

        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    /***
     * 递归版本
     */
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }


    /**
     * 迭代版本
     */
    public static void merge_sort_2(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for (block = 1; block < len; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while (start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
    }
}
