package com.bzh.offer.剑指.栈_队列;

import java.util.LinkedList;

/**
 * Created by biezhihua on 16-8-25.
 */
public class 栈的压入和弹出序列 {

    /**
     * 题目:
     * 输入两个整数序列,第一个序列表示栈的压入顺序,请判断第二个序列是为该栈的弹出顺序.
     * 假设压入栈的所有数字均不相等.
     * 假如序列1,2,3,4,5是某栈的压栈序列,序列4,5,3,2,1是该栈序列对应的一个弹出序列,
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列.
     * <p>
     * <p>
     * 思路:
     * 判断一个序列是不是栈的弹出序列的规律:
     * 如果下一个弹出的数字刚刚好是栈顶数字,那么直接弹出,如果下一个弹出的数字不在栈顶,就把压栈序列中还没有入栈的数字压入辅助栈,
     * 直到把需要弹出的数字压入栈为止.
     * 如果所有的数字都压入栈了仍然没有找到下一个弹出数字,那么该序列不可能是一个弹出序列.
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        int[] c = {5,4, 3, 2, 1};
        int[] d = {4,3};
        int[] e = {3,4};

        System.out.println(isPopOrder(a, b));
        System.out.println(isPopOrder(a, c));
        System.out.println(isPopOrder(d, e));
    }

    private static boolean isPopOrder(int[] pushOrder, int[] popOrder) {

        if (pushOrder == null || popOrder == null) {
            return false;
        }

        if (pushOrder.length == 0 || popOrder.length == 0) {
            return false;
        }

        if (pushOrder.length != popOrder.length) {
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < popOrder.length) {
            int popValue = popOrder[popIndex++];
            while (pushIndex < pushOrder.length) {
                int pushValue = pushOrder[pushIndex++];
                stack.push(pushValue);
                if (pushValue == popValue) {
                    break;
                }
            }
            if (stack.pop() != popValue) {
                return false;
            }
        }
        return true;
    }
}
