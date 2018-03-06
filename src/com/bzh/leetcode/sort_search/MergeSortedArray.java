package com.bzh.leetcode.sort_search;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArray {

    @Test
    public void test() {
        int[] num1 = new int[6];
        num1[0] = 1;
        num1[1] = 2;
        num1[2] = 3;

        int[] num2 = new int[]{2, 3, 4};

        merge(num1, 3, num2, 3);

        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 3, 4}, num1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m];
                m--;
            } else {
                nums1[m + n + 1] = nums2[n];
                n--;
            }
        }

        while (n >= 0) {
            nums1[n] = nums2[n];
            n--;
        }
    }

}
