package com.bzh.offer.剑指;

/**
 * Created by biezhihua on 16-8-26.
 */
public class 丑数 {

    /**
     * 题目:
     * 我们把只包含因子2,3,5的数称为丑数(ugly number).
     * 求从小到大的顺序第1500个丑数.
     * 例如6,8都是丑数,但是14不是,因为它包含因子7.习惯上我们把1当做一个丑数.
     * <p>
     * 逐个判断每个整数是不是丑数的方法,直观但不够高效.
     * 其最大的问题是,每个数字都需要计算,即时一个数字不是丑数,我们还是需要对它做求余和除法操作.该算法效率非常低,16秒左右.
     * <p>
     * 创建数组保存已经找到的丑数,用空间换时间,时间花费0.001秒左右.
     * 根据丑数的定义,丑数应该是另一个丑数乘以2,3,5的结果.因此我们可以创建一个数组,里面的数字是排序好的丑数,每一个丑数都是前面的丑数乘以2,3,5得到的.
     * <p>
     * 这种思路的关键在于怎样确保数组里面的丑数是排序好的.假设数组中已经有若干个丑数排序好后存放在数组中,并且把已有最大的丑数记作M,接下来分析如何生成下一个丑数.
     * 该丑数肯定是前面的某一个丑数乘以2,3,5,的结果,所以我们首先考虑把已有的每个丑数乘以2.在乘以2的时候,能够得到若干小于或等于M的结果.
     * 由于是按照顺序生成的,小于或等于M肯定已经在数组中了,我们不需要再次考虑.还会得到若干大于M的结果,但是我们只需要第一个大于M的结果.
     * 我们把第一个乘以2以后大于M的结果记为M2.同样,我们把已有的丑数乘以3和5,能得到第一个大于M的结果M3和M5.那么下一个丑数应该是M2,M3,M5这三个数的最小值.
     * <p>
     * 前面分析的时候,提到把已有的每个丑数分别乘以2,3,5.事实上这不是必须的,因为已有的丑数是按照顺序存放在数组中的.
     * 对于乘以2而言,肯定存在某一个丑数T2,排在它之前的每一个丑数乘以2得到的记过都小于已有的最大丑数,在它之后的每一个丑数乘以2的到的结果都会太大.
     * 我们只需要记下这个位置,同时每次生成新的丑数的时候,去更新这个T2.
     * 对于乘以3和5而言,也存在相同的T3和T5
     */

    public static void main(String[] args) {
        // 16s
//        long start = System.currentTimeMillis();
//        System.out.println(getUglyNumber(1500));
//        System.out.println((System.currentTimeMillis() - start) / 1000f);

        long start = System.currentTimeMillis();
        System.out.println(getUglyNumber2(1500));
        System.out.println((System.currentTimeMillis() - start) / 1000f);

    }

    static int getUglyNumber2(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[index];

        uglyNumbers[0] = 1;

        int nextUglyIndex = 1;

        // T2 T3 T5
        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;


        while (nextUglyIndex < index) {

            // M2,M3,M5中取最大的.
            int min = min(uglyNumbers[multiply2Index] * 2, uglyNumbers[multiply3Index] * 3, uglyNumbers[multiply5Index] * 5);

            uglyNumbers[nextUglyIndex] = min;

            // 更新T2,T3,T5
            while (uglyNumbers[multiply2Index] * 2 <= uglyNumbers[nextUglyIndex]) {
                multiply2Index++;
            }
            while (uglyNumbers[multiply3Index] * 3 <= uglyNumbers[nextUglyIndex]) {
                multiply3Index++;
            }
            while (uglyNumbers[multiply5Index] * 5 <= uglyNumbers[nextUglyIndex]) {
                multiply5Index++;
            }

            nextUglyIndex++;
        }

        return uglyNumbers[nextUglyIndex - 1];

    }

    static int min(int n1, int n2, int n3) {
        int min = (n1 < n2) ? n1 : n2;
        return min < n3 ? min : n3;
    }


    static boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }

        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }

        return number == 1;
    }

    static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            ++number;
            if (isUgly(number)) {
                ++uglyFound;
            }
        }
        return number;
    }
}
