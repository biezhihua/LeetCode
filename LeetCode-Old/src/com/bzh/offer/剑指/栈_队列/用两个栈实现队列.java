package com.bzh.offer.剑指.栈_队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by biezhihua on 16-8-24.
 */
public class 用两个栈实现队列 {

    static class CQueue<T> {
        Deque<T> stack_1 = new LinkedList<T>();
        Deque<T> stack_2 = new LinkedList<T>();

        void appendTail(T t) {
            stack_1.push(t);
        }

        T deleteHead() {
            //  若第二个栈不为空
            if (stack_2.isEmpty()) {
                while (!stack_1.isEmpty()) {
                    stack_2.push(stack_1.pop());
                }
            }

            if (!stack_2.isEmpty()) {
                return stack_2.pop();
            }
            return null;
        }
    }

    public static void main(String[] args) {
//        queue.offer();
//        queue.poll();
//        stack.push();
//        stack.pop()
    }
}
