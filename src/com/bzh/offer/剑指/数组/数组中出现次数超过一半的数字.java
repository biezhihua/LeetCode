package com.bzh.offer.剑指.数组;

/**
 * Created by biezhihua on 16-8-26.
 */
public class 数组中出现次数超过一半的数字 {

    /**
     * 题目:
     * 数组中有一个数字出现的次数超过数组长度的一半,请找出这个数字.
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}
     * 由于数字2在数组横纵出现了5次,超过数组长度的一半,因此输出2.
     * <p>
     * 思路:
     * 数组中一个数字出现的次数超过数组长度的一半,也就是说它出现的次数比其他所有数字出现的次数的和还要多.
     * 因此可以考虑在遍历的时候保存两个值:
     * 一个数组中的一个数字,一个是次数.
     * 当我们遍历到下一个数字的时候,如果下一个数字和我们之前保存的数字相同,则次数加1;
     * 如果下个数字和保存的数字不相同,则次数减1.
     * 如果次数为0,我们需要保存下一个数字,并把次数设为1.
     * <p>
     * 由于我们要找的数字出现的次数比其他的数字出现的之和还要多,那么要找的数字肯定是最后一次把次数设为1时对应的数字.
     *
     * 另外,还要检查结果数字,是否在数组中占一半以上.
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(isHalf(a));

        System.out.println(isHalf(b));
    }

    private static boolean isHalf(int[] a) {
        int result = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (result == a[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = a[i];
                count = 1;
            }
        }
        return checkMoreThanHalf(a, result);
    }

    private static boolean checkMoreThanHalf(int[] a, int result) {
        int times = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == result) {
                times++;
            }
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= a.length) {
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }
}
