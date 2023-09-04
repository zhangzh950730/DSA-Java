package com.zzh.leetcode._1901_2000;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1921_eliminateMaximum {
    public static void main(String[] args) {
        _1921_eliminateMaximum eliminateMaximum = new _1921_eliminateMaximum();
        int[] dist = new int[]{3, 2, 4};
        int[] speed = new int[]{5, 3, 2};
        int ans = eliminateMaximum.eliminateMaximum(dist, speed);
        Assert.assertEquals(3, ans);
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(arrivalTimes);
        for (int i = 0; i < n; i++) {
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }
        return n;
    }

}
