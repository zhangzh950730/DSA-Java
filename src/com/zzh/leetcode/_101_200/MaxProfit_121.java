package com.zzh.leetcode;

import com.zzh.Assert;

import java.util.Map;

/**
 * 买卖股票的最佳时机
 *
 * @author zhangzhihao
 * @date 2020/6/2 9:00
 */
public class MaxProfit_121 {
    /**
     * 一次遍历
     */
    static class Solution {
        public static int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else if (maxProfit < prices[i] - minPrice) {
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;
        }

        public static void main(String[] args) {
            int i = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
            Assert.equals(i, 5);

            i = maxProfit(new int[]{7, 6, 4, 3, 1});
            Assert.equals(i, 0);

            i = maxProfit(new int[]{});
            Assert.equals(i, 0);
        }
    }
}