package com.bzh.offer.剑指.数组;

/**
 * Created by biezhihua on 16-8-24.
 */
public class 旋转数组的最小数 {

    /**
     * 题目:
     * 把一个数组最开始的若干个元素搬到数组的末尾,我们称之为数组的旋转.
     * 输入一个递增排序的数组的一个旋转,输出旋转数组的最小元素.
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转,该数组的最小值为1.
     */


    /**
     * 思路:
     * 普通的遍历一遍O(n)的算法并不是很好,没有考虑到旋转数组的特性.
     * 什么是旋转数组的特性?就是最左侧的值,大于等于最右侧的值.
     * 这样我们可以考虑从首尾两端开始检测最小树.
     * <p>
     * 可以参考二分查找,并结合旋转数组的特性.
     * 找到数组的中间值,如果中间值大于最左侧的值,那么最小值应该在中间值的右侧.
     * 如果中间值小于最右侧的值,那么最小值应该在中间值的左侧.
     */


    public static void main(String[] args) {
        int[] a = {4, 5, 6, 1, 2, 3};
        int[] b = {1, 0, 1, 1, 1, 1, 1};

        System.out.println(min(a));
        System.out.println(min(b));
    }

    static int min(int[] a) {

        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int height = a.length - 1;
        int mid = 0;
        while (a[low] >= a[height]) {

            // 退出条件
            if (height - low == 1) {
                mid = height;
                break;
            }

            mid = (low + height) / 2;

            if (a[mid] == a[low] && a[mid] == a[height]) {
                int result = a[low];
                for (int i = low; i <= height; i++) {
                    if (result > a[i]) {
                        result = a[i];
                    }
                }
                return result;
            } else if (a[mid] >= a[low]) {
                low = mid;
            } else if (a[mid] <= a[height]) {
                height = mid;
            }

        }

        return a[mid];
    }
}
