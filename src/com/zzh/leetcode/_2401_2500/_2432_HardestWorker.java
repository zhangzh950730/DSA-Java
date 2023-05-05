package com.zzh.leetcode._2401_2500;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2432_HardestWorker {
    public static void main(String[] args) {
        _2432_HardestWorker hardestWorker = new _2432_HardestWorker();
        int n = 10;
        int[][] logs = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        int result = hardestWorker.hardestWorker(n, logs);
        Assert.assertEquals(result, 1);

        logs = new int[][]{{1, 1}, {3, 7}, {2, 12}, {7, 17}};
        result = hardestWorker.hardestWorker(n, logs);
        Assert.assertEquals(result, 3);

        logs = new int[][]{{0, 10}, {1, 20}};
        result = hardestWorker.hardestWorker(n, logs);
        Assert.assertEquals(result, 0);

        logs = new int[][]{{36, 3}, {1, 5}, {12, 8}};
        result = hardestWorker.hardestWorker(n, logs);
        Assert.assertEquals(result, 12);

    }

    public int hardestWorker(int n, int[][] logs) {
        int maxTime = 0, preTime = 0, minId = n;
        for (int[] log : logs) {
            int id = log[0];
            int currentTime = log[1];
            int usedTime = currentTime - preTime;
            if (usedTime > maxTime) {
                maxTime = usedTime;
                minId = id;
            } else if (usedTime == maxTime) {
                minId = Math.min(minId, id);
            }
            preTime = currentTime;
        }
        return minId;
    }

}
