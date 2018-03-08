package com.bzh.offer.排序.交换排序;

import java.util.Arrays;

/**
 * https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
 * 步骤为：
 * 从数列中挑出一个元素，称为"基准"（pivot），
 * 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。
 * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。
 * 这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 */
public class QuickSort {

    public static void quickSort(int a[], int low, int height) {
        if (low < height) {
            int pos = quickPass(a, low, height);
            quickSort(a, low, pos - 1);
            quickSort(a, pos + 1, height);
        }
    }

    public static int quickPass(int a[], int low, int height) {
        int key = a[low];
        while (low < height) {
            while (low < height && a[height] >= key) {
                height--;
            }

            if (low < height) {
                a[low] = a[height];
                low++;
            }

            while (low < height && a[low] <= key) {
                low++;
            }

            if (low < height) {
                a[height] = a[low];
                height--;
            }
        }

        a[low] = key;
        return low;
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 9, 11, 6, 99, 22, 55};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
