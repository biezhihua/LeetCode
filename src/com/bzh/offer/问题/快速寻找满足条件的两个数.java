package com.bzh.offer.问题;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by biezhihua on 16-8-16.
 */
public class 快速寻找满足条件的两个数 {

    public static void main(String[] args) {
        int[] a = new int[10000];
        Random random = new Random(47);

        for (int i = 0; i < 10000; i++) {
            a[i] = random.nextInt(10000 + 1);
        }
        int target = 200;

        Arrays.sort(a);

        int index1 = -1;
        int index2 = -1;

        for (int i = 0, j = a.length - 1; i < j; ) {
            if (a[i] + a[j] == target) {
                index1 = a[i];
                index2 = a[j];
                break;
            } else if (a[i] + a[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println("index1=" + index1 + ", index2=" + index2);
    }

}
