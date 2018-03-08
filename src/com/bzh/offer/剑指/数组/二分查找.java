package com.bzh.offer.剑指.数组;

/**
 * https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95
 *
 * 在计算机科学中，二分搜索（英语：binary search），
 * 也称折半搜索（英语：half-interval search）[1]、对数搜索（英语：logarithmic search）[2]，
 * 是一种在有序数组中查找某一特定元素的搜索算法。
 *
 * 搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，
 * 而且跟开始一样从中间元素开始比较。如果在某一步骤数组为空，则代表找不到。这种搜索算法每一次比较都使搜索范围缩小一半。
 */
public class 二分查找 {

    /**
     * 有序数组/每次折半查找
     */
    static int binarySearch(int[] a, int key) {

        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int height = a.length - 1;

        while (low < height) {
            int mid = (low + height) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                height = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
