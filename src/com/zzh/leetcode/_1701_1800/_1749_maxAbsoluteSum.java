package com.zzh.leetcode._1701_1800;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1749_maxAbsoluteSum {

    public static void main(String[] args) {
        _1749_maxAbsoluteSum maxAbsoluteSum = new _1749_maxAbsoluteSum();
        int[] nums;
        int ans;

        nums = new int[]{1, -3, 2, 3, -4};
        ans = maxAbsoluteSum.maxAbsoluteSum(nums);
        Assert.assertEquals(5, ans);

        nums = new int[]{2, -5, 1, -4, 3, -2};
        ans = maxAbsoluteSum.maxAbsoluteSum(nums);
        Assert.assertEquals(8, ans);

    }

    /**
     * 前缀和
     */
    public int maxAbsoluteSum(int[] nums) {
        int s = 0, mx = 0, mn = 0;
        for (int x : nums) {
            s += x;
            if (s > mx) mx = s;
            else if (s < mn) mn = s;
        }
        return mx - mn;
    }

    /**
     * 动态规划
     */
    public int maxAbsoluteSum1(int[] nums) {
        int ans = 0, fMax = 0, fMin = 0;
        for (int x : nums) {
            fMax = Math.max(fMax, 0) + x;
            fMin = Math.min(fMin, 0) + x;
            ans = Math.max(ans, Math.max(fMax, -fMin));
        }
        return ans;
    }
}
