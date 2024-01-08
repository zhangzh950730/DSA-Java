package com.zzh.leetcode._2201_2300;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2269_divisorSubstrings {
    public static void main(String[] args) {
        _2269_divisorSubstrings divisorSubstrings = new _2269_divisorSubstrings();
        int ans = divisorSubstrings.divisorSubstrings(240, 2);
        Assert.assertEquals(2, ans);
    }

    public int divisorSubstrings(int num, int k) {
        long[] cnt = new long[2];
        int mod = (int) Math.pow(10, k);
        String.valueOf(num).chars().limit(k - 1).forEach(i -> cnt[1] = cnt[1] * 10 + i - '0');
        String.valueOf(num).chars().skip(k - 1).forEach(i -> {
            cnt[1] = cnt[1] * 10 + i - '0';
            cnt[1] %= mod;
            if (cnt[1] > 0 && num % cnt[1] == 0) cnt[0]++;
        });
        return (int) cnt[0];
    }
}
