package com.bzh.offer.剑指;

public class 位运算_二进制中1的个数 {

    public static void main(String[] args) {
    }

    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fib(n - 1);
    }

    public int fib_2(int n) {
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = result * i;
        }
        return result;
    }


    public int bitCount2(int x) {

        int count = 0;

        while (x != 0) {
            count += x & 1;
            x = x >> 1;

        }
        return count;
    }

    public int bitCount3(int x) {
        int count = 0;
        while (x != 0) {
            if (x < 0) {
                count++;
            }
            x = x << 1;
        }
        return count;
    }

    /**
     * 经过发现，把一个整数减去1，都是把最右边的1变成0.
     * 如果它的右边还有0的话，就是把所有的0变成1，而它左边的所有位都保持不变。
     *
     * 以1100为例，它减去1的结果是:1011，再把1100与1011做位运算，得到的结果是1000，
     * 我们把最右边的1变成了0，结果刚好就是1000（成功的把最右的1去掉了）。
     *
     * 经过分析总结后就是：把一个整数减去1，在和原整数做与运算，会把该整数的最右侧一个1变成0.
     * 那么一个整数中的二进制表示中有多少个1，就可以进行多少次这样的操作。
     *
     */
    public int bitCount4(int x) {
        int count = 0;
        while (x != 0) {
            x &= x - 1;
            count++;
        }
        return count;
    }
}