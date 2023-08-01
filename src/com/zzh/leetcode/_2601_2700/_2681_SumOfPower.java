package com.zzh.leetcode._2601_2700;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2681_SumOfPower {
    public static void main(String[] args) {
        _2681_SumOfPower sumOfPower = new _2681_SumOfPower();
        int[] nums;
        int ans;

        nums = new int[]{2, 1, 4};
        ans = sumOfPower.sumOfPower(nums);
        Assert.assertEquals(141, ans);

        nums = new int[]{1, 1, 1};
        ans = sumOfPower.sumOfPower(nums);
        Assert.assertEquals(7, ans);
    }

    public int sumOfPower(int[] nums) {
        final long MOD = (long) 1e9 + 7;
        Arrays.sort(nums);
        long ans = 0, s = 0;
        for (long x : nums) {
            ans = (ans + x * x % MOD * (x + s)) % MOD;
            s = (2 * s + x) % MOD;
        }
        return (int) ans;
    }

}
