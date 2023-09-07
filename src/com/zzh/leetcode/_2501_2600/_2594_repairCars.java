package com.zzh.leetcode._2501_2600;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 * https://leetcode.cn/problems/minimum-time-to-repair-cars/solutions/2177199/er-fen-da-an-pythonjavacgo-by-endlessche-keqf/?envType=daily-question&envId=2023-09-07
 */
public class _2594_repairCars {
    public static void main(String[] args) {
        _2594_repairCars repairCars = new _2594_repairCars();
        int[] ranks;
        int cars;
        long ans;

        ranks = new int[]{4, 2, 3, 1};
        cars = 10;
        ans = repairCars.repairCars(ranks, cars);
        Assert.assertEquals(16, ans);

        ranks = new int[]{5, 1, 8};
        cars = 6;
        ans = repairCars.repairCars(ranks, cars);
        Assert.assertEquals(16, ans);

        ranks = new int[]{1, 1, 3, 3};
        cars = 74;
        ans = repairCars.repairCars(ranks, cars);
        Assert.assertEquals(576, ans);

    }

    /**
     * 优化
     */
    public long repairCars(int[] ranks, int cars) {
        int minRank = Integer.MAX_VALUE;
        int[] cnt = new int[101];
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
            cnt[rank]++;
        }

        long left = 0, right = (long) minRank * cars * cars;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            long s = 0;
            for (int rank = minRank; rank <= 100; rank++) {
                s += (long) Math.sqrt((double) mid / rank) * cnt[rank];
            }
            if (s >= cars) right = mid;
            else left = mid;
        }
        return right;
    }

    /**
     * 二分
     */
    public long repairCars1(int[] ranks, int cars) {
        if (ranks.length == 0) return 0L;
        int minRank = Arrays.stream(ranks).min().getAsInt();
        long left = 0, right = (long) minRank * cars * cars;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            int s = 0;
            for (int rank : ranks) {
                s += Math.sqrt((double) mid / rank);
            }
            if (s >= cars) right = mid;
            else left = mid;
        }
        return right;
    }
}
