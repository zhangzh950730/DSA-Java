package com.zzh.leetcode._701_800;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _746_minCostClimbingStairs {

    public static void main(String[] args) {
        _746_minCostClimbingStairs minCostClimbingStairs = new _746_minCostClimbingStairs();
        int[] cost = {10, 15, 20};
        int ans = minCostClimbingStairs.minCostClimbingStairs(cost);
        Assert.assertEquals(15, ans);

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        ans = minCostClimbingStairs.minCostClimbingStairs(cost);
        Assert.assertEquals(6, ans);
    }

    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0, f1 = 0;
        for (int i = 1; i < cost.length; i++) {
            int f = Math.min(f1 + cost[i], f0 + cost[i - 1]);
            f0 = f1;
            f1 = f;
        }
        return f1;
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[n];
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return dfs(n, cost, mem);
    }

    private int dfs(int i, int[] cost, int[] mem) {
        if (i <= 1) return 0;
        if (mem[i] != -1) return mem[i];
        int ans1 = dfs(i - 1, cost, mem) + cost[i - 1];
        int ans2 = dfs(i - 2, cost, mem) + cost[i - 2];
        return mem[i] = Math.min(ans1, ans2);
    }

}
