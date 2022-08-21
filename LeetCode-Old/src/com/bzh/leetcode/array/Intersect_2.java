package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Intersect_2 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2, 2}, intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> tmp = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            map.put(nums1[i], (value == null ? 0 : value) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                tmp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[tmp.size()];
        int i = 0;
        for (Integer e : tmp)
            result[i++] = e;
        return result;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{2, 2}, intersect1(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    public int[] intersect1(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> tmp = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums2[j] > nums1[i]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                tmp.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[tmp.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = tmp.get(k);
        }
        return result;
    }
}
