package com.bzh.offer.剑指.数组;

/**
 * Created by biezhihua on 16-8-28.
 */
public class 数字在排序数组中出现的次数 {

    /**
     * 题目:
     * 统计一个数字在排序数组中出现的次数.
     * 例如输入排序数组{1,2,3,3,3,3,4,5},由于3在这个数中出现了4次,输出4.
     * <p>
     * 思路1:
     * 如何利用二分查找找到第一个k?
     * 二分查找算法总是先拿数组中间的数组和k作比较.
     * 如果中间数字比k大,那么k只可能出现数组的前半段,下一轮只在数组的前半段查找就可以了.
     * 如果中间数字比k小,那么k只可能出现数组的后半段,下一轮只在数组的后半段查找就可以了.
     * 如果中间数组和k相等,先判断这个数字是不是第一个k.
     * 如果位于中间数字前面的一个数字不是k,那么此时中间的数字刚好就是第一个k.
     * 如果中间数字的前面一个数字也是k,也就是说第一个k肯定在数组的前半段,下一轮仍然需要在数组的前半段查找.
     * <p>
     * 基于同样的思路可以在排序数组中找到最后一个k.
     * 如果中间数字比k大,那么k只能出现在数组的前半段.
     * 如果中间数字比k小,那么k只能出现在数组的后半段.
     * 如果中间数子和k相等,需要判断这个数字是不是最后一个k.
     * 如果位于中间数字后面一个数字不是k,那么此时中间的数字刚好就是最后一个k.
     * 如果中间数字的后面一个数字也是k,也就是说第一个k肯定在数组的后半段,下一轮仍然需要在数组的后半段查找.
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getKCount(a, 3));
    }

    static int getKCount(int[] a, int k) {
        if (a != null && a.length != 0) {
            int first = getFirstK(a, k, 0, a.length - 1);
            int last = getLastK(a, k, 0, a.length - 1);
            if (first > -1 && last > -1) {
                return last - first + 1;
            }
        }
        return -1;
    }


    static int getFirstK(int[] a, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midData = a[mid];
        if (midData == k) {
            if ((mid > 0 && a[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midData < k) {
            // 在后半段
            start = mid + 1;
        } else if (midData > k) {
            // 在前半段
            end = mid - 1;
        }

        return getFirstK(a, k, start, end);
    }


    static int getLastK(int[] a, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midData = a[mid];
        if (midData == k) {
            if ((mid > 0 && a[mid + 1] != k) || mid == a.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midData < k) {
            // 在后半段
            start = mid + 1;
        } else if (midData > k) {
            // 在前半段
            end = mid - 1;
        }

        return getLastK(a, k, start, end);
    }
}
