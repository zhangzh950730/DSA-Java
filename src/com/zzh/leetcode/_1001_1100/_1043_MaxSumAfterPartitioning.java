package com.zzh.leetcode._1001_1100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1043_MaxSumAfterPartitioning {

    public static void main(String[] args) {
        _1043_MaxSumAfterPartitioning maxSumAfterPartitioning = new _1043_MaxSumAfterPartitioning();
        int res = maxSumAfterPartitioning.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3);
        Assert.assertEquals(res, 84);
        res = maxSumAfterPartitioning.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4);
        Assert.assertEquals(res, 83);
        res = maxSumAfterPartitioning.maxSumAfterPartitioning(new int[]{1}, 1);
        Assert.assertEquals(res, 1);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return d[n];
    }

}
