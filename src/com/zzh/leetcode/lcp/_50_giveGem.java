package com.zzh.leetcode.lcp;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _50_giveGem {
    public static void main(String[] args) {
        _50_giveGem giveGem = new _50_giveGem();
        int[] gem;
        int[][] operations;
        int ans;

        gem = new int[]{100, 0, 50, 100};
        operations = new int[][]{{0, 2}, {0, 1}, {3, 0}, {3, 0}};
        ans = giveGem.giveGem(gem, operations);
        Assert.assertEquals(75, ans);
    }

    public int giveGem(int[] gem, int[][] operations) {
        if (gem.length == 0) return 0;
        for (int[] operation : operations) {
            int donate = gem[operation[0]] / 2;
            gem[operation[0]] -= donate;
            gem[operation[1]] += donate;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int x : gem) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        return max - min;
    }
}
