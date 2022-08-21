package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcodechina.com/explore/suan-fa/card/chu-ji-suan-fa/1/di-yi-zhang-jie/21/
 */
public class RemoveDuplicates {

    @Test
    public void test() {
        Assert.assertEquals(1, removeDuplicates(new int[]{1, 1, 1}));
        Assert.assertEquals(0, removeDuplicates(new int[]{}));
        Assert.assertEquals(1, removeDuplicates(new int[]{1}));
        Assert.assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
        Assert.assertEquals(3, removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 3}));
        Assert.assertEquals(4, removeDuplicates(new int[]{1, 2, 3, 4, 4, 4, 4}));
        Assert.assertEquals(5, removeDuplicates(new int[]{1, 2, 3, 4, 5}));
    }

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int resultLength = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[resultLength++] = nums[i];
                nums[resultLength] = nums[i + 1];
            }
        }

        if (nums.length > 0) {
            resultLength++;
        }

        return resultLength;
    }


    @Test
    public void test1() {
        Assert.assertEquals(1, removeDuplicates1(new int[]{1, 1, 1}));
        Assert.assertEquals(0, removeDuplicates1(new int[]{}));
        Assert.assertEquals(1, removeDuplicates1(new int[]{1}));
        Assert.assertEquals(2, removeDuplicates1(new int[]{1, 1, 2}));
        Assert.assertEquals(3, removeDuplicates1(new int[]{1, 1, 2, 2, 2, 3, 3}));
        Assert.assertEquals(4, removeDuplicates1(new int[]{1, 2, 3, 4, 4, 4, 4}));
        Assert.assertEquals(5, removeDuplicates1(new int[]{1, 2, 3, 4, 5}));
    }

    public int removeDuplicates1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;

        for (; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }

        return j+1;
    }
}
