package com.bzh.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcodechina.com/explore/suan-fa/card/chu-ji-suan-fa/1/di-yi-zhang-jie/22/
 * 假设有一个数组，它的第 i 个元素是一个给定的股票在第 i 天的价格。
 * 设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。然而，你不能同时参与多个交易（你必须在再次购买前出售股票）。
 * <p>
 * <p>
 * <p>
 * 单次交易利润 = 低点买入 + 高点卖出
 * <p>
 * 总利润 = 多次交易利润总和
 * <p>
 */
public class MaxProfile {

    @Test
    public void test() {
//        Assert.assertEquals(0, maxProfit(new int[]{}));
//        Assert.assertEquals(0, maxProfit(new int[]{10, 1}));
//        Assert.assertEquals(9, maxProfit(new int[]{1, 10}));
//        Assert.assertEquals(9, maxProfit(new int[]{1, 10, 10}));
//        Assert.assertEquals(9, maxProfit(new int[]{1, 10, 10, 10, 10}));
//        Assert.assertEquals(9, maxProfit(new int[]{1, 1, 10, 10}));
//        Assert.assertEquals(18, maxProfit(new int[]{1, 1, 10, 10, 1, 10}));
//        Assert.assertEquals(9, maxProfit(new int[]{1, 1, 10, 10, 1, 1, 1, 0}));
//        Assert.assertEquals(17, maxProfit(new int[]{10, 0, 1, 10, 3, 5, 6, 5, 6, 4, 7, 1}));

        Assert.assertEquals(0, maxProfit2(new int[]{}));
        Assert.assertEquals(0, maxProfit2(new int[]{10, 1}));
        Assert.assertEquals(9, maxProfit2(new int[]{1, 10}));
        Assert.assertEquals(9, maxProfit2(new int[]{1, 10, 10}));
        Assert.assertEquals(9, maxProfit2(new int[]{1, 10, 10, 10, 10}));
        Assert.assertEquals(9, maxProfit2(new int[]{1, 1, 10, 10}));
        Assert.assertEquals(18, maxProfit2(new int[]{1, 1, 10, 10, 1, 10}));
        Assert.assertEquals(9, maxProfit2(new int[]{1, 1, 10, 10, 1, 1, 1, 0}));
        Assert.assertEquals(17, maxProfit2(new int[]{10, 0, 1, 10, 3, 5, 6, 5, 6, 4, 7, 1}));


        //  若prices[maxIndex] > prices[i] (转折出现)
        //      minIndex = i;
        //      maxIndex = i;
        //      minIndex <= maxIndex && maxProfit += prices[maxIndex] - prices[minIndex];
        //  若prices[minIndex] >= prices[i]
        //      minIndex = i;
        //  若prices[maxIndex] <= prices[i]
        //      maxIndex = i;
        //  最后 minIndex <= maxIndex &&  maxProfit += prices[maxIndex] - prices[minIndex];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int sum = 0;

        // 求多次交易的总利润，因为一个交易当前可以卖出买入
        // 那么总利润就是 多次高价减去低价之和

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }

        return sum;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[maxIndex] > prices[i]) {
                if (minIndex <= maxIndex) {
                    maxProfit += prices[maxIndex] - prices[minIndex];
                }
                minIndex = i;
                maxIndex = i;
            } else if (prices[minIndex] >= prices[i]) {
                minIndex = i;
            } else if (prices[maxIndex] <= prices[i]) {
                maxIndex = i;
            }
        }

        if (minIndex <= maxIndex) {
            maxProfit += prices[maxIndex] - prices[minIndex];
        }

        return maxProfit;
    }
}
