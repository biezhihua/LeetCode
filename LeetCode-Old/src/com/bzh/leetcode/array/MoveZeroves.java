package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class MoveZeroves {

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    public void moveZeroes(int[] nums) {
        int curIndex = nums.length - 1;
        int lastIndex = nums.length - 1;
        int count = 0;

        while (curIndex >= 0) {
            if (nums[curIndex] == 0) {
                count = lastIndex - curIndex;
                for (int i = 0; i < count; i++) {
                    nums[curIndex + i] = nums[curIndex + i + 1];
                }
                nums[lastIndex] = 0;
                lastIndex--;
            }
            curIndex--;
        }
    }

}
