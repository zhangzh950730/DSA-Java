package com.zzh.leetcode.lcp;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _06_minCount {
    public static void main(String[] args) {

    }

    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += (coin + 1) / 2;
        }
        return ans;
    }
}
