package com.bzh.leetcode;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 * <p>
 * Example:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Code_3_4_TwoSum {

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(nums, 9));
        Assert.assertArrayEquals(new int[]{-1, -1}, twoSum(nums, 0));
        Assert.assertArrayEquals(new int[]{-1, -1}, twoSum(nums, 16));
    }

    // 1. 确定数组是否有序，无须则需要升序排序
    // 2. 确定startIndex以及endIndex，
    // 其中如果数组最后一个元素小于target值，那么endIndex为array.length-1
    // 如果数组最后一个元素大于target值，那么从后向前（或者二分查找）查找到第一个小于等于target值的索引，其为endIndex
    // 3. 计算array[startIndex]+array[endIndex]的结果result与target比较，
    // 若result大于target，那么endIndex-1
    // 若result小于target，那么startIndex+1
    // 直至result等于target，或者startIndex>=endIndex，程序结束返回startIndex和endIndex或者错误信息

    int[] twoSum(int[] nums, int target) {
        int[] rs = new int[]{-1, -1};

        if (nums == null || nums.length <= 1)
            return rs;

        // 1. 排序数组

        int startIndex = 0;
        int endIndex = nums.length - 1;

        // 2. 确定endIndex值，此处还可以使用二分查找
        while (startIndex < endIndex && nums[endIndex] > target) {
            endIndex--;
        }

        // 3. 确定结果
        while (startIndex < endIndex) {
            if (nums[startIndex] + nums[endIndex] > target) {
                endIndex--;
            } else if (nums[startIndex] + nums[endIndex] < target) {
                startIndex++;
            } else {
                rs[0] = startIndex;
                rs[1] = endIndex;
                return rs;
            }
        }
        return rs;
    }
}
