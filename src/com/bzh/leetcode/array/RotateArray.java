package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 0));
        Assert.assertArrayEquals(new int[]{7, 1, 2, 3, 4, 5, 6}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 1));
        Assert.assertArrayEquals(new int[]{6, 7, 1, 2, 3, 4, 5}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
        Assert.assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 1}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 6));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 7));
        Assert.assertArrayEquals(new int[]{2, 1}, rotate(new int[]{1, 2}, 1));
        Assert.assertArrayEquals(new int[]{2, 1}, rotate(new int[]{1, 2}, 3));
    }

    public int[] rotate(int[] nums, int k) {

        k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }

        return result;
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{7, 1, 2, 3, 4, 5, 6}, rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 1));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 0));
        Assert.assertArrayEquals(new int[]{6, 7, 1, 2, 3, 4, 5}, rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
        Assert.assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 1}, rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 6));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 7));
        Assert.assertArrayEquals(new int[]{2, 1}, rotate1(new int[]{1, 2}, 1));
        Assert.assertArrayEquals(new int[]{2, 1}, rotate1(new int[]{1, 2}, 3));
    }

    public int[] rotate1(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return nums;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }


    @Test
    public void test2() {


        // 1
        // 1, 2, 3, 4, 5, 6, 7

        //       3
        // 1, 2, 1, 4, 5, 6, 7

        //             5
        // 1, 2, 1, 4, 3, 6, 7

        //                   7
        // 1, 2, 1, 4, 3, 6, 5

        //    2
        // 1, 7, 1, 4, 3, 6, 5

        //          4
        // 1, 7, 1, 2, 3, 6, 5

        //                6
        // 1, 7, 1, 2, 3, 4, 5

        // 1
        // 6, 7, 1, 2, 3, 4, 5


        // 1
        // 1, 2, 3, 4, 5, 6

        //       3
        // 1, 2, 1, 4, 5, 6

        //             5
        // 1, 2, 1, 4, 3, 6

        //    2
        // 5, 2, 1, 4, 3, 6

        //          4
        // 5, 2, 1, 2, 3, 6

        //                6
        // 5, 2, 1, 2, 3, 4

        //    6
        // 5, 6, 1, 2, 3, 4

        int[] nums = {1, 2, 3, 4, 5, 6};

//        rotate2(nums, 2);
//        Assert.assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, nums);
//
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 1);
        Assert.assertArrayEquals(new int[]{7, 1, 2, 3, 4, 5, 6}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 0);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, nums);


        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 2);
        Assert.assertArrayEquals(new int[]{6, 7, 1, 2, 3, 4, 5}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 4);
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 5);
        Assert.assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 6);
        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 1}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 7);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, nums);

        nums = new int[]{1, 2};
        rotate2(nums, 1);
        Assert.assertArrayEquals(new int[]{2, 1}, nums);

        nums = new int[]{1, 2};
        rotate2(nums, 3);
        Assert.assertArrayEquals(new int[]{2, 1}, nums);

        // -1 -100 3 99

        // 99 -100 3 -1

        // -100 99 3 -1

        // -100 3 99 -1

        nums = new int[]{-1, -100, 3, 99};
        rotate2(nums, 3);
        Assert.assertArrayEquals(new int[]{-100, 3, 99, -1}, nums);

        nums = new int[]{1, 2};
        rotate2(nums, 1);
        Assert.assertArrayEquals(new int[]{2, 1}, nums);
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length == 0 || (k %= nums.length) == 0) {
            return;
        }
        int length = nums.length;
        int start = 0;
        int i = 0;
        int cur = nums[i];
        int cnt = 0;

        while (cnt++ < length) {
            i = (i + k) % length;
            int t = nums[i];
            nums[i] = cur;
            if (i == start) {
                ++start;
                ++i;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
    }

}
