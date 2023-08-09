package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _69_mySqrt {
    public static void main(String[] args) {
        _69_mySqrt mySqrt = new _69_mySqrt();
        int ans;

        ans = mySqrt.mySqrt(0);
        Assert.assertEquals(0, ans);

        ans = mySqrt.mySqrt(2147395599);
        Assert.assertEquals(46339, ans);

    }

    public int mySqrt(int x) {
        int left = 0, right = x, mid, ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}
