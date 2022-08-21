package com.bzh.offer.问题;

/**
 * Created by biezhihua on 16-8-10.
 */
public class 象棋将帅问题 {

    public static final int HALF_BITS_LENGTH = 4;

    public static final int FULL_MASK = 0X000000FF;

    public static final int RMASK = 0X0000000F;

    public static final int LMASK = 0X000000F0;

    public static final int GRIDW = 3;

    public static int RSET(int b, int n) {
        b = (b & LMASK) | n;
        return b;
    }

    public static int LSET(int b, int n) {
        b = (b & RMASK) | (n << HALF_BITS_LENGTH);
        return b;
    }

    public static int RGET(int b) {
        b = b & RMASK;
        return b;
    }

    public static int LGET(int b) {
        b = (b & LMASK) >> HALF_BITS_LENGTH;
        return b;
    }


    public static void main(String[] args) {
//        method1();

        method3();
    }

    private static void method1() {
        int b = 0;
        for (b = LSET(b, 1); LGET(b) <= GRIDW * GRIDW; b = LSET(b, LGET(b) + 1)) {
            for (b = RSET(b, 1); RGET(b) <= GRIDW * GRIDW; b = RSET(b, RGET(b) + 1)) {
                if (LGET(b) % GRIDW != RGET(b) % GRIDW) {
                    System.out.println("A=" + LGET(b) + ", B=" + RGET(b));
                }
            }
        }
    }

    private static void method2() {
        int i = 81;
        while (i-- > 0) {
            if (i / 9 % 3 != i % 9 % 3) {
                System.out.println("A=" + (i / 9 + 1) + ",B=" + (i % 9 + 1));
            }
        }
    }

    /**
     * (0 ～ 8) / 9  = 0
     * (0 ~ 8) % 9 = (0 ~ 8)
     */
    private static void method3() {
        int i = 0;
        while (i < 81) {
            if (i / 9 % 3 != i % 9 % 3) {
                System.out.println("A=" + (i / 9 + 1) + ",B=" + (i % 9 + 1));
            }
            i++;
        }
    }
}
