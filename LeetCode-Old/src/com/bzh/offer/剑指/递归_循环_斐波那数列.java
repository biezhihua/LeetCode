package com.bzh.offer.剑指;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by biezhihua on 16-8-8.
 */
public class 递归_循环_斐波那数列 {

    // 递归
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 非递归
    public static long fib2(long n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long x, y, z;
        x = 0;
        y = 1;
        for (long i = 2; i <= n; i++) {
            z = y;
            y = y + x;
            x = z;

        }
        return y;
    }

    @Deprecated
    private static double fib3(double n) {
        return (double) ((Math.pow((1 + Math.sqrt(5.0)) / 2, n) - Math.pow((1 - Math.sqrt(5.0)) / 2, n)) / Math.sqrt(5.0));
    }

    static BigInteger big0 = new BigInteger("0");
    static BigInteger big1 = new BigInteger("1");
    static BigInteger big2 = new BigInteger("2");

    public static BigInteger Fibonacci(BigInteger target) {


        if (target.compareTo(big0) == 0 || target.compareTo(big1) == 0) {
            return target;
        }

        BigInteger x = big0;
        BigInteger y = big1;
        BigInteger z = null;

        for (BigInteger i = big2; i.compareTo(target) <= 0; ) {
            z = y;
            y = y.add(x);
            x = z;
            i = i.add(big1);
        }
        return y;
    }

    public static void main(String[] args) {

//        for (int i = 1; i <= 9; i++) {
//            long startTime = System.currentTimeMillis();
//            long fib2 = fib2(i * i);
//            long endTime = System.currentTimeMillis();
//            System.out.println("普通" + " time = " + (endTime - startTime) + " " + (i * i) + "=" + fib2);
//        }

//        for (int i = 1; i <= 9; i++) {
//            long startTime = System.currentTimeMillis();
//            int fib = fib(i * i);
//            long endTime = System.currentTimeMillis();
//            System.out.println("递归 " + fib + " time = " + (endTime - startTime));
//        }

        // 1

        // 987 fib(16)
        System.out.println("fib(16)=" + fib2(16) + ", " + (13 * fib2(8) + 21 * fib2(9)));

        // 75025 fib(25)
        System.out.println("fib(25)=" + fib2(25) + ", " + (55 * fib2(16) + 34 * fib2(15)));

        //14930352 fib(36)
        System.out.println("fib(36)=" + fib2(36) + ", " + (89 * fib2(24) + 144 * fib2(25)));

        // 2

        // fib(3)
        System.out.println("fib(3)=" + fib2(3) + ", " + (1 * fib2(0) + 2 * fib(1)));

        // fib(8)
        System.out.println("fib(8)=" + fib2(8) + ", " + (3 * fib2(3) + 5 * fib(4)));

        // fib(15)
        System.out.println("fib(15)=" + fib2(15) + ", " + (8 * fib2(8) + 13 * fib(9)));


//        int i = 449;
//        long startTime = System.currentTimeMillis();
//        BigInteger fib3 = Fibonacci(new BigInteger("" + i * i));
//        long endTime = System.currentTimeMillis();
//        System.out.println("大数 " + " time = " + (endTime - startTime) + " i=" + i + " " + (i * i) + "=" + fib3.toString());

        long startTime2 = System.currentTimeMillis();
        ArrayList<BigInteger> newFibonacciBigInteger = getNewFibonacciBigInteger();
        long endTime2 = System.currentTimeMillis();
        BigInteger result = newFibonacciBigInteger.get(newFibonacciBigInteger.size() - 1);
        System.out.println("大数 " + " time = " + (endTime2 - startTime2) + " size =" + newFibonacciBigInteger.size() + " " + (450 * 450) + " =" + result.toString());
//        System.out.println("是否相等:" + fib3.equals(result));

        BigDecimal bigDecimal = new BigDecimal(result.toString());
        System.out.println(bigDecimal.stripTrailingZeros().toString());

    }

    private static ArrayList<Long> getNewFibonacci() {

        // 主值列表
        ArrayList<Long> fibList1 = new ArrayList<>();

        // 副职列表
        ArrayList<Long> fibList2 = new ArrayList<>();

        long fib_0 = 0;
        long fib_1 = 1;

        // 主值小系数
        long primary_small_coffcient = 2;
        // 主值大系数
        long primary_large_coffcient = 3;

        // 副值小系数
        long secondary_small_cofficent = 1;
        // 副值大系数
        long secondary_large_cofficent = 2;

        // 待加入值
        long primary = 0;
        long secondary = 0;

        for (long i = 1; i <= 9; i++) {

            long to_be_calculated = i * i;

            if (to_be_calculated == 1) {
                // 添加开始值
                fibList1.add(1L);
                continue;
            } else if (to_be_calculated == 4) {
                // 计算起始副值
                secondary = secondary_small_cofficent * fib_0 + secondary_large_cofficent * fib_1;
                fibList2.add(secondary);

                // 计算起始主值
                primary = primary_small_coffcient * fib_0 + primary_large_coffcient * fib_1;
                fibList1.add(primary);
            } else {
                // 计算副值
                secondary = secondary_small_cofficent * fibList2.get(fibList2.size() - 1) + secondary_large_cofficent * fibList1.get(fibList1.size() - 1);
                fibList2.add(secondary);

                // 计算主值
                primary = primary_small_coffcient * fibList2.get(fibList2.size() - 2) + primary_large_coffcient * fibList1.get(fibList1.size() - 1);
                fibList1.add(primary);

            }

            // 更新系数
            long temp_secondary_large_cofficent = secondary_large_cofficent;
            secondary_small_cofficent = secondary_small_cofficent + secondary_large_cofficent;
            secondary_large_cofficent = secondary_small_cofficent + temp_secondary_large_cofficent;

            // 更新系数
            long temp_primary_large_coffcient = primary_large_coffcient;
            primary_small_coffcient = primary_small_coffcient + primary_large_coffcient;
            primary_large_coffcient = primary_small_coffcient + temp_primary_large_coffcient;
        }
        return fibList1;
    }

    private static ArrayList<BigInteger> getNewFibonacciBigInteger() {

        ArrayList<String> dataSource = new ArrayList<>();

        // 主值列表
        ArrayList<BigInteger> fibList1 = new ArrayList<>();

        // 副职列表
        ArrayList<BigInteger> fibList2 = new ArrayList<>();

        BigInteger fib_0 = new BigInteger("0");
        BigInteger fib_1 = new BigInteger("1");

        // 1.0E10
        BigInteger threshold = new BigInteger("10000000000");

        // 主值小系数
        BigInteger primary_small_coffcient = new BigInteger("2");
        // 主值大系数
        BigInteger primary_large_coffcient = new BigInteger("3");

        // 副值小系数
        BigInteger secondary_small_cofficent = new BigInteger("1");
        // 副值大系数
        BigInteger secondary_large_cofficent = new BigInteger("2");

        // 待加入值
        BigInteger primary = new BigInteger("0");
        BigInteger secondary = new BigInteger("0");


        for (BigInteger i = new BigInteger("1"); i.compareTo(new BigInteger("449")) <= 0; ) {

            BigInteger to_be_calculated = i.multiply(i);

            i = i.add(new BigInteger("1"));

            if (to_be_calculated.compareTo(new BigInteger("1")) == 0) {
                // 添加开始值
                fibList1.add(new BigInteger("1"));
                dataSource.add("1");
                continue;
            } else if (to_be_calculated.compareTo(new BigInteger("4")) == 0) {
                // 计算起始副值
                secondary = secondary_small_cofficent.multiply(fib_0).add(secondary_large_cofficent.multiply(fib_1));
                fibList2.add(secondary);

                // 计算起始主值
                primary = primary_small_coffcient.multiply(fib_0).add(primary_large_coffcient.multiply(fib_1));
                fibList1.add(primary);
                dataSource.add(primary.toString());
            } else {
                // 计算副值
                secondary = secondary_small_cofficent.multiply(fibList2.get(fibList2.size() - 1)).add(secondary_large_cofficent.multiply(fibList1.get(fibList1.size() - 1)));
                fibList2.add(secondary);

                // 计算主值
                primary = primary_small_coffcient.multiply(fibList2.get(fibList2.size() - 2)).add(primary_large_coffcient.multiply(fibList1.get(fibList1.size() - 1)));
                fibList1.add(primary);
                if (primary.compareTo(threshold) > 0) {
                    // 科学计数
                    long starTime = System.currentTimeMillis();
                    String temp = primary.toString();
                    StringBuilder sb = new StringBuilder();
                    sb.append(temp.substring(0, 1));
                    sb.append(".");
                    sb.append(temp.substring(1, 11));
                    sb.append("E");
                    sb.append(temp.length());
                    long endTime = System.currentTimeMillis();
                    System.out.println(endTime - starTime);
                } else {
                    dataSource.add(primary.toString());
                }
            }

            // 更新系数
            BigInteger temp_secondary_large_cofficent = secondary_large_cofficent;
            secondary_small_cofficent = secondary_small_cofficent.add(secondary_large_cofficent);
            secondary_large_cofficent = secondary_small_cofficent.add(temp_secondary_large_cofficent);

            // 更新系数
            BigInteger temp_primary_large_coffcient = primary_large_coffcient;
            primary_small_coffcient = primary_small_coffcient.add(primary_large_coffcient);
            primary_large_coffcient = primary_small_coffcient.add(temp_primary_large_coffcient);


        }
        return fibList1;
    }

}