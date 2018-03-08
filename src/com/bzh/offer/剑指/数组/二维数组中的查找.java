package com.bzh.offer.剑指.数组;

public class 二维数组中的查找 {

    /**
     * 题目：
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入一个整数，判断二维数组数组中是否有该数。
     */

    public static void main(String[] args) {

        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 12}, {6, 8, 11, 15}};

        System.out.println(find(a, a.length, a[0].length, 1));
    }

    public static boolean find(int[][] a, int rows, int columns, int key) {
        
        if (a == null || rows == 0 || columns == 0) {
            return false;
        } else {
            int row = 0;
            int column = columns - 1;

            while (row < rows && column >= 0) {

                if (a[row][column] == key) {
                    return true;
                } else if (a[row][column] > key) {

                    column--;
                } else if (a[row][column] < key) {
                    row++;
                }
            }
        }
        return false;
    }
}
