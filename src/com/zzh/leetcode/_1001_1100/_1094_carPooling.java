package com.zzh.leetcode._1001_1100;

import org.junit.Assert;

import java.util.TreeMap;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 * @see <a href="https://leetcode.cn/problems/car-pooling/solutions/2550264/suan-fa-xiao-ke-tang-chai-fen-shu-zu-fu-9d4ra/?envType=daily-question&envId=2023-12-02"></>
 */
public class _1094_carPooling {
    public static void main(String[] args) {
        _1094_carPooling carPooling = new _1094_carPooling();
        int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        boolean ans = carPooling.carPooling(trips, 4);
        Assert.assertFalse(ans);
    }

    /**
     * 写法1 差分数组
     */
    public boolean carPooling1(int[][] trips, int capacity) {
        int[] difference = new int[1001];
        for (int[] trip : trips) {
            int num = trip[0], from = trip[1], to = trip[2];
            difference[from] += num;
            difference[to] -= num;
        }
        int sum = 0;
        for (int d : difference) {
            sum += d;
            if (sum > capacity) return false;
        }
        return true;
    }

    /**
     * 写法2 平衡树 treeMap
     */
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> difference = new TreeMap<>();
        for (int[] trip : trips) {
            int num = trip[0], from = trip[1], to = trip[2];
            difference.merge(from, num, Integer::sum);
            difference.merge(to, -num, Integer::sum);
        }
        int sum = 0;
        for (int d : difference.values()) {
            sum += d;
            if (sum > capacity) return false;
        }
        return true;
    }

}
