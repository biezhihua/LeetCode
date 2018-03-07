package com.bzh.leetcode.dp;

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(prices[i], buy);
            result = Math.max(result, prices[i] - buy);
        }

        return result;
    }
}
