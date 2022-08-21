package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class RotateImage {
    @Test
    public void test() {
        int[][] test1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(test1);
        Assert.assertArrayEquals(new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        }, test1);
    }


    public void rotate(int[][] matrix) {

        int length = matrix.length;

        // 调换对角元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = tmp;
            }
        }

        // 调换列元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = tmp;
            }
        }
    }
}
