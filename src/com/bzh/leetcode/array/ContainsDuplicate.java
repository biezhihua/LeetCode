package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    @Test
    public void containsDuplicate() {
        Assert.assertEquals(false, containsDuplicate(new int[]{}));
        Assert.assertEquals(false, containsDuplicate(new int[]{1}));
        Assert.assertEquals(false, containsDuplicate(new int[]{1, 2}));
        Assert.assertEquals(true, containsDuplicate(new int[]{1, 2, 1, 2}));
        Assert.assertEquals(true, containsDuplicate(new int[]{1, 1, 2}));
        Assert.assertEquals(true, containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 7}));
    }

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;
    }

    @Test
    public void containsDuplicate1() {
        Assert.assertEquals(false, containsDuplicate1(new int[]{}));
        Assert.assertEquals(false, containsDuplicate1(new int[]{1}));
        Assert.assertEquals(false, containsDuplicate1(new int[]{1, 2}));
        Assert.assertEquals(true, containsDuplicate1(new int[]{1, 2, 1, 2}));
        Assert.assertEquals(true, containsDuplicate1(new int[]{1, 1, 2}));
        Assert.assertEquals(true, containsDuplicate1(new int[]{1, 2, 3, 4, 5, 6, 7, 7}));
    }

    public boolean containsDuplicate1(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
