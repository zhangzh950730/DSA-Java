package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _70_climbStairs {
    public static void main(String[] args) {
        _70_climbStairs climbStairs = new _70_climbStairs();
        int ans = climbStairs.climbStairs(3);
        Assert.assertEquals(3, ans);
    }

    public int climbStairs(int n) {
        int f0 = 1, f1 = 1;
        for (int i = 2; i <= n; i++) {
            int f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f1;
    }

    public int climbStairs1(int n) {
        int[] mem = new int[n + 1];
        return dfs(n, mem);
    }

    private int dfs(int n, int[] mem) {
        if (n <= 1) return 1;
        if (mem[n] != 0) return mem[n];
        return mem[n] = dfs(n - 1, mem) + dfs(n - 2, mem);
    }

}
