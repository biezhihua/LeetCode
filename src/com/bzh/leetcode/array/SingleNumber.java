package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    @Test
    public void test() {
        Assert.assertEquals(0, singleNumber(new int[]{}));
        Assert.assertEquals(3, singleNumber(new int[]{1, 1, 3, 2, 2}));
        Assert.assertEquals(3, singleNumber(new int[]{1, 3, 1, 2, 4, 2, 4}));
        Assert.assertEquals(3, singleNumber(new int[]{1, 4, 2, 3, 2, 4, 1}));
    }

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            Integer value = map.get(nums[i]);
            map.put(nums[i], (value == null ? 0 : value) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, singleNumber1(new int[]{}));
        Assert.assertEquals(3, singleNumber1(new int[]{1, 1, 3, 2, 2}));
        Assert.assertEquals(3, singleNumber1(new int[]{1, 3, 1, 2, 4, 2, 4}));
        Assert.assertEquals(3, singleNumber1(new int[]{1, 4, 2, 3, 2, 4, 1}));
        Assert.assertEquals(3, singleNumber1(new int[]{1, 1, 2, 2, 3, 4, 4}));
    }

    public int singleNumber1(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length ; i = i + 2) {
            if (i + 1 >= nums.length ) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, singleNumber2(new int[]{}));
        Assert.assertEquals(3, singleNumber2(new int[]{1, 1, 3, 2, 2}));
        Assert.assertEquals(3, singleNumber2(new int[]{1, 3, 1, 2, 4, 2, 4}));
        Assert.assertEquals(3, singleNumber2(new int[]{1, 4, 2, 3, 2, 4, 1}));
        Assert.assertEquals(3, singleNumber2(new int[]{1, 1, 2, 2, 3, 4, 4}));
    }

    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;

        // 1000
        // 0111
        // 0000

        // 0111
        // 0110
        // 0110

        // 0110
        // 0101
        // 0100

        // 0100
        // 0011
        // 0000

    }
}
