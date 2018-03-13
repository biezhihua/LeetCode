package com.bzh.offer.剑指.栈_队列;

import java.util.LinkedList;

/**
 * Created by biezhihua on 16-8-25.
 */
public class 包含min函数的栈 {

    /**
     * 题目:
     * 定义栈的数据结构,请在该类型中实现一个能够的得到最小的min函数,在该栈中,调用min,push,pop函数都是O(1)时间复杂度.
     * <p>
     * 思路:
     * 可以把每次的最小元素(之前的最小元素和新压入栈的元素两者较小值)都保存起来放到另外一个辅助栈中.
     * <p>
     * 如果每次都把最小元素压入辅助栈,就能保证辅助栈的栈顶元素一直都是最小元素.当最小元素从数据栈内被弹出之后,同时弹出辅助栈的栈顶元素,
     * 此时辅助栈的栈顶元素就是下一个最小值.
     */


    static class MinStack {

        LinkedList<Integer> data = new LinkedList<Integer>();
        LinkedList<Integer> min = new LinkedList<Integer>();

        Integer pop() {
            min.pop();
            return data.pop();
        }

        void push(Integer t) {
            if (min.isEmpty()) {
                min.push(t);
            } else {
                Integer peek = min.peek();
                if (peek < t) {
                    min.push(peek);
                } else {
                    min.push(t);
                }
            }
            data.push(t);
        }

        int min() {
            if (min.isEmpty()) {
                return -1;
            }
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(4);
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        minStack.push(5);
        minStack.pop();
        System.out.println(minStack.min());


    }
}
