package com.bzh.leetcode.array;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 * <p>
 * Example:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(nums, 9));
        Assert.assertArrayEquals(new int[]{-1, -1}, twoSum(nums, 10));
    }

    int[] twoSum(int[] nums, int target) {
        int[] rs = new int[]{-1, -1};

        if (nums == null || nums.length <= 1)
            return rs;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                rs[0] = hashMap.get(nums[i]);
                rs[1] = i;
                return rs;
            } else {
                hashMap.put(target - nums[i], i);
            }
        }

        return rs;
    }
}
